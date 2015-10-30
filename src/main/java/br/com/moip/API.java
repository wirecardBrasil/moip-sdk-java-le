package br.com.moip;

import br.com.moip.api.OrderAPI;

public class API {

    private final Client client;

    public API(final Client client) {
        this.client = client;
    }

    public OrderAPI order() {
        return new OrderAPI(client);
    }

}
