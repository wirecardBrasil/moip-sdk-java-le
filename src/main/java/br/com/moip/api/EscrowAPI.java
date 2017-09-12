package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.resource.Escrow;

public class EscrowAPI {
    private final Client client;

    public EscrowAPI(Client client) {
        this.client = client;
    }

    public Escrow release(String escrowId) {
        return client.post(String.format("/v2/escrows/%s/release", escrowId), null, Escrow.class);
    }
}
