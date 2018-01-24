package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.RefundRequest;
import br.com.moip.resource.Errors;
import br.com.moip.resource.Refund;
import br.com.moip.response.RefundsListResponse;

import java.util.List;

public class RefundAPI {

    private final Client client;

    public RefundAPI(Client client) {
        this.client = client;
    }

    public Refund order(RefundRequest refundRequest) {
        return client.post(String.format("/v2/orders/%s/refunds", refundRequest.getId()), refundRequest, Refund.class);
    }

    public Refund payment(RefundRequest refundRequest) {
        return client.post(String.format("/v2/payments/%s/refunds", refundRequest.getId()), refundRequest, Refund.class);
    }

    public Refund get(String refundId) {
        return client.get(String.format("/v2/refunds/%s", refundId), Refund.class);
    }

    public RefundsListResponse list(String id) {
        if (id.charAt(0) == 'P') return client.get(String.format("/v2/payments/%s/refunds", id), RefundsListResponse.class);

        return client.get(String.format("/v2/orders/%s/refunds", id), RefundsListResponse.class);
    }
}
