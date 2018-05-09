package br.com.moip;

import br.com.moip.authentication.Authentication;
import br.com.moip.exception.MoipException;
import br.com.moip.exception.UnauthorizedException;
import br.com.moip.exception.UnexpectedException;
import br.com.moip.exception.ValidationException;
import br.com.moip.resource.Errors;
import br.com.moip.ssl.SSLSupport;
import br.com.moip.util.GsonFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.http.entity.ContentType;

import static br.com.moip.util.DataHelper.jsonToUrlEncodedString;

public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
    public static final String PRODUCTION = "https://api.moip.com.br";
    public static final String SANDBOX = "https://sandbox.moip.com.br";
    public static final String CONNECT_PRODUCTION = "https://connect.moip.com.br";
    public static final String CONNECT_SANDBOX = "https://connect-sandbox.moip.com.br";
    private static String USER_AGENT;
    private final String RESPONSE_BODY_400 = "400";
    private final String RESPONSE_BODY_404 = "404";

    static {
        try {
            InputStream inputStream = Client.class.getResourceAsStream("/moipJavaSDK.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            USER_AGENT = properties.getProperty("userAgent");
        } catch (Exception e) {
            USER_AGENT = "MoipJavaSDK/UnknownVersion (+https://github.com/moip/moip-sdk-java/)";
        }
    }

    private final String endpoint;
    private final Authentication authentication;
    private final Gson gson;

    public Client(final String endpoint, final Authentication authentication) {
        this.endpoint = endpoint;
        this.authentication = authentication;
        this.gson = GsonFactory.gson();
    }

    public <T> T post(final String path, final Class<T> type) {
        RequestProps props = RequestPropsBuilder.requestPropsBuilder().method("POST").path(path).type(type).contentType(ContentType.APPLICATION_JSON);
        return doRequest(props);
    }

    public <T> T post(final String path, final Object object, final Class<T> type) {
        RequestProps props = RequestPropsBuilder.requestPropsBuilder().method("POST").path(path).object(object).type(type).contentType(ContentType.APPLICATION_JSON);
        return doRequest(props);
    }

    public <T> T post(final String path, final Object object, final Class<T> type, ContentType contentType) {
        RequestProps props = RequestPropsBuilder.requestPropsBuilder().method("POST").path(path).object(object).type(type).contentType(contentType);
        return doRequest(props);
    }

    public <T> T put(final String path, final Object object, final Class<T> type) {
        RequestProps props = RequestPropsBuilder.requestPropsBuilder().method("PUT").path(path).object(object).type(type).contentType(ContentType.APPLICATION_JSON);
        return doRequest(props);
    }

    public <T> T get(String path, Class<T> type) {
        RequestProps props = RequestPropsBuilder.requestPropsBuilder().method("GET").path(path).type(type).contentType(ContentType.APPLICATION_JSON);
        return doRequest(props);
    }

    public <T> T get(String path, Class<T> type, String acceptVersion) {
        RequestProps props = RequestPropsBuilder.requestPropsBuilder().method("GET").path(path).type(type).contentType(ContentType.APPLICATION_JSON).accept(acceptVersion);
        return doRequest(props);
    }

    public <T> T delete(String path, Class<T> type) {
        RequestProps props = RequestPropsBuilder.requestPropsBuilder().method("DELETE").path(path).object(null).type(type).contentType(ContentType.APPLICATION_JSON);
        return doRequest(props);
    }

    private <T> T doRequest(final RequestProps requestProps) {
        try {
            URL url = new URL(endpoint + requestProps.path);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", USER_AGENT);
            conn.setRequestProperty("Content-type", requestProps.contentType.getMimeType());
            if (requestProps.accept != null) conn.setRequestProperty("Accept", requestProps.accept);

            conn.setRequestMethod(requestProps.method);

            // Disable TLS 1.0
            if (conn instanceof HttpsURLConnection) {
                ((HttpsURLConnection) conn).setSSLSocketFactory(new SSLSupport());
            }

            if (authentication != null) {
                authentication.authenticate(conn);
            }

            LOGGER.debug("---> {} {}", requestProps.method, conn.getURL().toString());
            logHeaders(conn.getRequestProperties().entrySet());

            if (requestProps.object != null) {
                conn.setDoOutput(true);
                String body = getBody(requestProps.object, requestProps.contentType);

                LOGGER.debug("{}", body);

                DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
                writer.write(body);
                writer.close();
                wr.flush();
                wr.close();
            }

            LOGGER.debug("---> END HTTP");

            int responseCode = conn.getResponseCode();

            LOGGER.debug("<--- {} {}", responseCode, conn.getResponseMessage());
            logHeaders(conn.getHeaderFields().entrySet());

            StringBuilder responseBody = new StringBuilder();

            responseBody = responseBodyTreatment(responseBody, responseCode, conn);

            LOGGER.debug("{}", responseBody.toString());
            LOGGER.debug("<-- END HTTP ({}-byte body)", conn.getContentLength());

            return gson.fromJson(responseBody.toString(), requestProps.<T>getType());
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e) {
            throw new MoipException("Error occurred connecting to Moip API: " + e.getMessage(), e);
        }
    }

    private StringBuilder responseBodyTreatment(StringBuilder responseBody, int responseCode, HttpURLConnection conn) {

        try {

            if (responseCode >= 200 && responseCode < 299) {
                responseBody = readBody(conn.getInputStream());
            }

            if (responseCode == 401) {
                throw new UnauthorizedException();
            }

            if (responseCode >= 400 && responseCode < 499) {
                responseBody = readBody(conn.getErrorStream());
                LOGGER.debug("API ERROR {}", responseBody.toString());

                Errors errors = new Errors();

                try {

                    errors = gson.fromJson(responseBody.toString(), Errors.class);

                } catch (Exception e) {

                    LOGGER.debug("There was not possible cast the JSON to object");
                }

                throw new ValidationException(responseCode, conn.getResponseMessage(), errors);
            }

            if (responseCode >= 500) {
                throw new UnexpectedException();
            }

        } catch (IOException e) {
            throw new MoipException("Error occurred connecting to Moip API: " + e.getMessage(), e);
        }

        return responseBody;
    }

    private void logHeaders(Set<Map.Entry<String, List<String>>> entries) {
        for (Map.Entry<String, List<String>> header : entries) {
            if (header.getKey() != null) {
                LOGGER.debug("{}: {}", header.getKey(), header.getValue());
            }
        }
    }

    private StringBuilder readBody(final InputStream inputStream) throws IOException {
        StringBuilder body = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            body.append(inputLine);
        }
        in.close();

        return body;
    }

    private String getBody(Object object, ContentType contentType) {
        if (contentType == ContentType.APPLICATION_FORM_URLENCODED) {
            return jsonToUrlEncodedString((JsonObject) new JsonParser().parse(gson.toJson(object)));
        }

        return gson.toJson(object);
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public String getEndpoint() {
        return endpoint;
    }

    private static class RequestProps {

        protected String method;
        protected String path;
        protected Object object;
        protected Class type;
        protected ContentType contentType;
        protected String accept;

        public RequestProps() {}

        public String getMethod() { return method; }

        public String getPath() { return path; }

        public Object getObject() { return object; }

        public <T> Class<T> getType() { return type; }

        public ContentType getContentType() { return contentType; }

        public String getAccept() { return accept; }
    }

    private static class RequestPropsBuilder extends RequestProps {

        public static RequestPropsBuilder requestPropsBuilder() {
            return new RequestPropsBuilder();
        }

        public RequestPropsBuilder method(String method) {
            this.method = method;
            return this;
        }

        public RequestPropsBuilder path(String path) {
            this.path = path;
            return this;
        }

        public RequestPropsBuilder object(Object object) {
            this.object = object;
            return this;
        }

        public RequestPropsBuilder type(Class type) {
            this.type = type;
            return this;
        }

        public RequestPropsBuilder contentType(ContentType contentType) {
            this.contentType = contentType;
            return this;
        }

        public RequestPropsBuilder accept(String acceptVersion) {
            this.accept = acceptBuilder(acceptVersion);
            return this;
        }

        public String acceptBuilder(String version) {
            String value = "application/json";
            if(version == "2.1") value += ";version=" + version;
            return value;
        }
    }

}