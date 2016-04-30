package br.com.moip.response;

import br.com.moip.resource.Invoice;
import br.com.moip.resource.Links;
import br.com.moip.resource.invoice.Summary;

import java.util.List;

public class InvoiceListResponse {
    public static final String NEXT = "next";
    public static final String PREVIOUS = "previous";

    private List<Invoice> invoices;
    private Summary summary;
    private Links links;

    public String next() {
        return links.getLinks().get(NEXT).toString();
    }

    public String previous() {
        return links.getLinks().get(PREVIOUS).toString();
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return new StringBuilder("InvoiceListResponse{")
                .append("summary=").append(summary)
                .append(", invoices=").append(invoices)
                .append('}').toString();
    }
}