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
    private Links _links;

    public String next() {
        return _links.getLinks().get(NEXT).toString();
    }

    public String previous() {
        return _links.getLinks().get(PREVIOUS).toString();
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
        final StringBuilder sb = new StringBuilder("InvoiceListResponse{");
        sb.append("summary=").append(summary);
        sb.append(", invoices=").append(invoices);
        sb.append('}');
        return sb.toString();
    }
}