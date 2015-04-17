package br.com.moip;

import java.net.HttpURLConnection;

public interface Authentication {
	void authenticate(HttpURLConnection connection);
}