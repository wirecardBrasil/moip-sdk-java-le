package com.moip;

import java.net.HttpURLConnection;

public interface MoipAuthentication {
	public void authenticate(HttpURLConnection connection);
}