package br.com.moip.request;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class RequestTest {
	
	protected JsonObject getJsonFileAsJsonObject(String file) {
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream ("/jsons/" + file)));
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(br).getAsJsonObject();
		assertNotNull(json);
		return json;
	}

}
