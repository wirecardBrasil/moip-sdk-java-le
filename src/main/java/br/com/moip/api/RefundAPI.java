package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.RefundRequest;
import br.com.moip.resource.Refund;

public class RefundAPI {

    private final Client client;

    public RefundAPI(Client client) {
        this.client = client;
    }

    public Refund order(RefundRequest refundRequest) {
        return client.post("/v2/orders/" + refundRequest.getId() + "/refunds", refundRequest, Refund.class);
    }

    public Refund payment(RefundRequest refundRequest) {
        return client.post("/v2/payments/" + refundRequest.getId() + "/refunds", refundRequest, Refund.class);
    }

}
