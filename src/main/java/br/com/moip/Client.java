package br.com.moip;

import br.com.moip.authentication.Authentication;
import br.com.moip.exception.MoipException;
import br.com.moip.exception.UnexpectecException;
import br.com.moip.exception.ValidationException;
import br.com.moip.resource.Errors;
import br.com.moip.util.GsonFactory;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
    public static final String PRODUCTION = "https://api.moip.com.br";
    public static final String SANDBOX = "https://sandbox.moip.com.br";
    private static String USER_AGENT;

    static {
        try {
            InputStream inputStream = Client.class.getResourceAsStream("/moipJavaSDK.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            USER_AGENT = properties.getProperty("userAgent");
        } catch (Exception e) {
            USER_AGENT = "MoipJavaSDK/UnknownVersion";
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

    public <T> T post(final String path, final Object object, final Class<T> type) {
        try {
            URL url = new URL(endpoint + path);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", USER_AGENT);
            conn.setRequestProperty("Content-type", "application/json");

            if (authentication != null) {
                authentication.authenticate(conn);
            }

            conn.setDoOutput(true);

            LOGGER.debug("---> POST {}", url.toString());
            logHeaders(conn.getRequestProperties().entrySet());

            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(gson.toJson(object));
            wr.flush();
            wr.close();

            LOGGER.debug("---> END HTTP");

            int responseCode = conn.getResponseCode();

            LOGGER.debug("<--- {} {}", responseCode, conn.getResponseMessage());
            logHeaders(conn.getHeaderFields().entrySet());

            StringBuilder responseBody = new StringBuilder();
            if (responseCode >= 200 && responseCode < 299) {
                responseBody = readBody(conn.getInputStream());
            }

            if (responseCode >= 400 && responseCode < 499) {
                responseBody = readBody(conn.getErrorStream());

                Errors errors = gson.fromJson(responseBody.toString(), Errors.class);

                throw new ValidationException(responseCode, conn.getResponseMessage(), errors);
            }

            if (responseCode >= 500) {
                throw new UnexpectecException();
            }

            LOGGER.debug("");
            LOGGER.debug("{}", responseBody.toString());
            LOGGER.debug("<-- END HTTP ({}-byte body)", conn.getContentLength());

            return gson.fromJson(responseBody.toString(), type);
        } catch (java.io.IOException e) {
            throw new MoipException("Error occurred connecting to Moip API: " + e.getMessage(), e);
        }
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

}
