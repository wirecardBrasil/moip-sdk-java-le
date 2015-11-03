package br.com.moip.authentication;

import java.net.HttpURLConnection;

public class OAuth implements Authentication {
	private String accessToken;

	public OAuth(String accessToken) {
		this.accessToken = accessToken;
	}

	public void authenticate(HttpURLConnection connection) {
		connection.addRequestProperty("Authorization", "OAuth " + accessToken);
	}
}
