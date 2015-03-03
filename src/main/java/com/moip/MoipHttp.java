package com.moip;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MoipHttp {
	private MoipAuthentication authentication;
	private String endpoint;

	public MoipHttp(MoipAuthentication authentication) {
		this(authentication, Moip.PRODUCTION_ENDPOINT);
	}

	public MoipHttp(MoipAuthentication authentication, String endpoint) {
		this.authentication = authentication;
		this.endpoint = endpoint;
	}

	public HttpURLConnection createConnection(String path, String method) {
		URL url;
		HttpURLConnection connection;

		try {
			url = new URL("https://" + endpoint + path);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);

			authentication.authenticate(connection);
			
			return connection;
		} catch (MalformedURLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();

		}

		return null;
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
			System.out.printf("Request: \n%s\n\n", body);
			
			try {
				connection.setDoOutput(true);
				
				DataOutputStream jsonRequest = new DataOutputStream(connection.getOutputStream());
				
				jsonRequest.writeBytes(body);
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
			
			System.out.printf("Response: \n%s\n\n", jsonResponse.toString());
			
			return jsonResponse.toString();
		} catch (IOException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}

		return "";
	}

}
