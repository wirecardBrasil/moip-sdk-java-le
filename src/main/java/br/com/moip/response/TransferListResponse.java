package br.com.moip.response;

import br.com.moip.resource.Links;
import br.com.moip.resource.Transfer;
import br.com.moip.resource.invoice.Summary;

import java.util.List;

public class TransferListResponse {

    public static final String NEXT = "next";
    public static final String PREVIOUS = "previous";

    private List<Transfer> transfers;
    private Summary summary;
    private Links links;

    public String next() {
        return links.getLinks().get(NEXT).toString();
    }

    public String previous() {
        return links.getLinks().get(PREVIOUS).toString();
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return new StringBuilder("TransferListResponse{")
                .append("summary=").append(summary)
                .append(", transfers=").append(transfers)
                .append('}').toString();
    }
}
