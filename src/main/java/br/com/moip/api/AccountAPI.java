package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.resource.Account;

public class AccountAPI {

    private final Client client;

    public AccountAPI(final Client client) {
        this.client = client;
    }

    public Account get() {
        return client.get("/v2/accounts", Account.class);
    }
}
