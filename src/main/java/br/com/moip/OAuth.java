package br.com.moip;

import java.net.URLConnection;

public class OAuth implements Authentication {
	private String accessToken;

	public OAuth(String accessToken) {
		this.accessToken = accessToken;
	}

	public void authenticate(URLConnection connection) {
		connection
		.addRequestProperty("Authorization", "OAuth " + accessToken);
	}
}
