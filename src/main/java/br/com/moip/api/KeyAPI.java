package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.resource.Key;

public class KeyAPI {

    private final Client client;

    public KeyAPI(final Client client) {
        this.client = client;
    }

    public Key get() {
        return client.get("/v2/keys", Key.class);
    }
}
