package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.MultiorderRequest;
import br.com.moip.resource.Multiorder;

public class MultiorderAPI {

    private final Client client;

    public MultiorderAPI(final Client client) {
        this.client = client;
    }

    public Multiorder create(MultiorderRequest multiorder) {
        return client.post("/v2/multiorders", multiorder, Multiorder.class);
    }

    public Multiorder get(String multiorderId) {
        return client.get("/v2/multiorders/" + multiorderId, Multiorder.class);
    }
}
