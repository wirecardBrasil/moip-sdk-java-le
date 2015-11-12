package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.resource.Payment;

public class PaymentAPI {

    private final Client client;

    public PaymentAPI(final Client client) {
        this.client = client;
    }

    public Payment create(final String orderId, Payment payment) {
        return client.post("/v2/orders/" + orderId + "/payments", payment, Payment.class);
    }
}
