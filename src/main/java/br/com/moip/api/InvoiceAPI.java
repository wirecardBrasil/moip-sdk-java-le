package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.resource.Invoice;

public class InvoiceAPI {
    private final Client client;

    public InvoiceAPI(final Client client) {
        this.client = client;
    }

    public Invoice create(final Invoice invoice) {
        Invoice createdInvoice = client.post("/v2/invoices", invoice, Invoice.class);

        return createdInvoice;
    }
}