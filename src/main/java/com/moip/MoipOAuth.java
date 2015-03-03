package com.moip;

import java.net.HttpURLConnection;

public class MoipOAuth implements MoipAuthentication {
	private String accessToken;
	
	public MoipOAuth(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public void authenticate(HttpURLConnection connection) {
		connection
		.addRequestProperty("Authorization", "OAuth " + accessToken);
	}
}
