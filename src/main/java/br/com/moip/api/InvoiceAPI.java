package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.InvoiceRequest;
import br.com.moip.resource.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceAPI {
    private final Client client;

    public InvoiceAPI(final Client client) {
        this.client = client;
    }

    public Invoice create(final InvoiceRequest invoice) {
        return client.post("/v2/invoices", invoice, Invoice.class);
    }


    public Invoice get(final String id) {
        return client.get("/v2/invoices/" + id, Invoice.class);
    }

    public List<Invoice> list() {
        return client.get("/v2/invoices", new ArrayList<Invoice>().getClass());
    }
}