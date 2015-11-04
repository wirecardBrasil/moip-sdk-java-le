package br.com.moip.authentication;

import java.net.HttpURLConnection;

public class BasicAuth implements Authentication {
	private final String token;
	private final String key;

	public BasicAuth(String token, String key) {
		this.token = token;
		this.key = key;
	}

	public String getToken() {
		return token;
	}

	public String getKey() {
		return key;
	}

	public void authenticate(HttpURLConnection connection) {
		String authorization = Base64.encode((token + ":" + key).getBytes());

		connection.setRequestProperty("Authorization", "Basic " + authorization);
	}
}
