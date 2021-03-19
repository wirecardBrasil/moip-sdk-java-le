package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.response.PlugPagTokenResponse;

public class PlugPagTokenAPI {

    private final Client client;

    public PlugPagTokenAPI(final Client client) {
        this.client = client;
    }

    public PlugPagTokenResponse get() {
        return client.get("/gapi/mpos/token", PlugPagTokenResponse.class);
    }

}
