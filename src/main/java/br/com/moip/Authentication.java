package br.com.moip;

import java.net.URLConnection;

public interface Authentication {
	void authenticate(URLConnection connection);
}