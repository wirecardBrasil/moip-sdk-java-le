package br.com.moip;

import br.com.moip.response.PlugPagTokenResponse;

public class PlugPagTokenV2API {

    private final Client client;

    public PlugPagTokenV2API(Client client) { this.client = client; }

    public PlugPagTokenResponse get() {
        return client.get("/gapi/plugpag/token", PlugPagTokenResponse.class);
    }

}
