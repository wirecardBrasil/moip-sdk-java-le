package br.com.moip;

import java.net.URLConnection;

public class BasicAuth implements Authentication {
	private final String token;
	private final String key;

	public BasicAuth(String token, String key) {
		this.token = token;
		this.key = key;
	}

	public void authenticate(URLConnection connection) {
		String authorization = Base64.encode((token + ":" + key).getBytes());

		connection.addRequestProperty("Authorization", "Basic " + authorization);
	}
}
