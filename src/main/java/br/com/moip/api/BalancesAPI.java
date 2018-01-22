package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.resource.Balances;

public class BalancesAPI {

    private final Client client;

    public BalancesAPI(final Client client) { this.client = client; }

    public Balances get() { return client.get("/v2/balances", Balances.class, "2.1"); }
}