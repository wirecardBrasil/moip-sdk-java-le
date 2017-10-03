package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.PaymentRequest;
import br.com.moip.resource.Multipayment;

public class MultipaymentAPI {

    private Client client;

    public MultipaymentAPI(final Client client) {
        this.client = client;
    }

    public Multipayment create(PaymentRequest multipayment) {
        return client.post(String.format("/v2/multiorders/%s/multipayments", multipayment.getOrderId()), multipayment, Multipayment.class);
    }

    public Multipayment get(String multipaymentId) {
        return client.get(String.format("/v2/multipayments/%s", multipaymentId), Multipayment.class);
    }

    public Multipayment capture(String multipaymentId) {
        return client.post(String.format("/v2/multipayments/%s/capture", multipaymentId), null, Multipayment.class);
    }

    public Multipayment cancelPreAuthorized(String multipaymentId) {
        return client.post(String.format("/v2/multipayments/%s/void", multipaymentId), null, Multipayment.class);
    }

}
