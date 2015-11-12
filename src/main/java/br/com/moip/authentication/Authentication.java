package br.com.moip.authentication;

import java.net.HttpURLConnection;

public interface Authentication {
	void authenticate(HttpURLConnection connection);
}