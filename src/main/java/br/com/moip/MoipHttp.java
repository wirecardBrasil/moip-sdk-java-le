package br.com.moip;

import br.com.moip.ssl.SSLSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.www.protocol.http.*;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.net.HttpURLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MoipHttp {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoipHttp.class);
    private static String USER_AGENT;

    static {
        try {
            InputStream inputStream = MoipHttp.class.getResourceAsStream("/moipJavaSDK.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            USER_AGENT = properties.getProperty("userAgent");
        } catch (Exception e) {
            USER_AGENT = "MoipJavaSDK/UnknownVersion";
        }
    }

    private Authentication authentication;
    private String endpoint;

    public MoipHttp(Authentication authentication) {
        this(authentication, Moip.PRODUCTION_ENDPOINT);
    }

    public MoipHttp(Authentication authentication, String endpoint) {
        this.authentication = authentication;
        this.endpoint = endpoint;
    }

    public URLConnection createConnection(String path, String method) {
        URL url;

        try {
            url = new URL(endpoint + path);

            SSLSupport sslSupport = new SSLSupport();
            URLConnection urlConnection = url.openConnection();

            if (urlConnection instanceof sun.net.www.protocol.http.HttpURLConnection) {
                ((HttpURLConnection) urlConnection).setRequestMethod(method);
            } else {
                ((HttpsURLConnection) urlConnection).setRequestMethod(method);
                ((HttpsURLConnection) urlConnection).setSSLSocketFactory(sslSupport);
            }

            authentication.authenticate(urlConnection);

            return urlConnection;

        } catch (MalformedURLException e) {
            throw new MoipException("Error trying to send request to Moip: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new MoipException("Error trying to send request to Moip: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            throw new MoipException("SSL Error trying to send request to Moip: " + e.getMessage(), e);
        } catch (KeyManagementException e) {
            throw new MoipException("SSL Error trying to send request to Moip: " + e.getMessage(), e);
        }
    }

    public String sendRequest(String path) {
        return sendRequest(path, "GET");
    }

    public String sendRequest(String path, String method) {
        return sendRequest(path, method, null);
    }

    public String sendRequest(String path, String method, String body) {
        URLConnection connection = createConnection(path, method);

        if (endpoint.startsWith("https")) {
            return sendHttpsRequest((HttpsURLConnection) connection, body);
        } else {
            return sendHttpRequest((HttpURLConnection) connection, body);
        }
    }

    private String sendHttpsRequest(HttpsURLConnection connection, String body) {
        BufferedReader bufferedReader;

        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("User-Agent", USER_AGENT);

        if (body != null && !body.isEmpty()) {
            LOGGER.debug("Request: {}", body);

            try {
                connection.setDoOutput(true);

                DataOutputStream jsonRequest = new DataOutputStream(connection.getOutputStream());

                jsonRequest.write(body.getBytes("UTF-8"));
                jsonRequest.flush();
                jsonRequest.close();

            } catch (IOException e) {
                throw new MoipException("Error trying to write json request to Moip: " + e.getMessage(), e);
            }
        }

        try {
            int responseCode = connection.getResponseCode();
            LOGGER.debug("Response code: {}", responseCode);

            StringBuilder jsonResponse = new StringBuilder();

            if (responseCode >= 200 && responseCode < 300) {
                bufferedReader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                jsonResponse.append(responseLine);
            }

            bufferedReader.close();

            connection.disconnect();

            LOGGER.debug("Response: {}", jsonResponse.toString());

            return jsonResponse.toString();
        } catch (IOException e) {
            throw new MoipException("Error trying to send request to Moip: " + e.getMessage(), e);
        }
    }

    /*
    ********************* TESTS PROPOSE ONLY ***********************
     * To run tests we use http mocked server instead of use https mocked server
     */
    private String sendHttpRequest(HttpURLConnection connection, String body) {
        BufferedReader bufferedReader;

        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("User-Agent", USER_AGENT);

        if (body != null && !body.isEmpty()) {
            LOGGER.debug("Request: {}", body);

            try {
                connection.setDoOutput(true);

                DataOutputStream jsonRequest = new DataOutputStream(connection.getOutputStream());

                jsonRequest.write(body.getBytes("UTF-8"));
                jsonRequest.flush();
                jsonRequest.close();

            } catch (IOException e) {
                throw new MoipException("Error trying to write json request to Moip: " + e.getMessage(), e);
            }
        }

        try {
            int responseCode = connection.getResponseCode();
            LOGGER.debug("Response code: {}", responseCode);

            StringBuilder jsonResponse = new StringBuilder();

            if (responseCode >= 200 && responseCode < 300) {
                bufferedReader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                jsonResponse.append(responseLine);
            }

            bufferedReader.close();

            connection.disconnect();

            LOGGER.debug("Response: {}", jsonResponse.toString());

            return jsonResponse.toString();
        } catch (IOException e) {
            throw new MoipException("Error trying to send request to Moip: " + e.getMessage(), e);
        }
    }
}
