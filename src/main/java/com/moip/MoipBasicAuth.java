package com.moip;

import java.net.HttpURLConnection;
import java.util.Base64;

public class MoipBasicAuth implements MoipAuthentication {
	private String token;
	private String key;

	public MoipBasicAuth(String token, String key) {
		this.token = token;
		this.key = key;
	}

	public void authenticate(HttpURLConnection connection) {
		String authorization = Base64.getEncoder().encodeToString(
				(token + ":" + key).getBytes());

		connection
				.addRequestProperty("Authorization", "Basic " + authorization);
	}
}
