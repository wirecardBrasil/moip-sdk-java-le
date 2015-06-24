package br.com.moip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

	public HttpURLConnection createConnection(String path, String method) {
		URL url;
		HttpURLConnection connection;

		try {
			url = new URL(endpoint + path);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);

			authentication.authenticate(connection);

			return connection;
		} catch (MalformedURLException e) {
			throw new MoipException("Error trying to send request to Moip: " + e.getMessage(), e);
		} catch (IOException e) {
			throw new MoipException("Error trying to send request to Moip: " + e.getMessage(), e);
		}
	}

	public String sendRequest(String path) {
		return sendRequest(path, "GET");
	}

	public String sendRequest(String path, String method) {
		return sendRequest(path, method, null);
	}

	public String sendRequest(String path, String method, String body) {
		HttpURLConnection connection = createConnection(path, method);
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
