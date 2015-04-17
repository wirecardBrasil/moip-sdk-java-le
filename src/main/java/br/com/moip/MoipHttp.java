package br.com.moip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MoipHttp {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoipHttp.class);

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

		if (body != null && !body.isEmpty()) {
			LOGGER.debug("Request: {}", body);

			try {
				connection.setDoOutput(true);

				DataOutputStream jsonRequest = new DataOutputStream(connection.getOutputStream());

				jsonRequest.write(body.getBytes("UTF-8"));
				jsonRequest.flush();
				jsonRequest.close();

			} catch (IOException e) {
				// TODO Bloco catch gerado automaticamente
				e.printStackTrace();
			}
		}

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			String responseLine;
			StringBuffer jsonResponse = new StringBuffer();

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
