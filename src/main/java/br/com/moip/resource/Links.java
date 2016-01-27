package br.com.moip.resource;

import java.util.HashMap;
import java.util.Map;

public class Links {

    private final Map<String, Object> links = new HashMap<>();

    public Links add(final String key, final Object link) {
        links.put(key, link);

        return this;
    }

    public Map<String, Object> getLinks() {
        return links;
    }
}