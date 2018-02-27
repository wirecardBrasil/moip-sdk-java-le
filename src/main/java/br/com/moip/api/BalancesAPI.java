package br.com.moip.api;

import br.com.moip.API;
import br.com.moip.Client;
import br.com.moip.resource.Balances;

public class BalancesAPI {

    private final Client client;

    private final String BALANCE_ENDPOINT = "/v2/balances";

    private final String API_VERSION = "2.1";

    public BalancesAPI(final Client client) { this.client = client; }

    public Balances get() { return client.get(BALANCE_ENDPOINT, Balances.class, API_VERSION); }
}