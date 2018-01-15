package br.com.moip.response;

import br.com.moip.resource.Entry;
import br.com.moip.resource.Links;
import br.com.moip.resource.invoice.Summary;

import java.util.ArrayList;
import java.util.List;

public class EntriesListResponse extends ArrayList<Entry> {

    public static final String NEXT = "next";
    public static final String PREVIOUS = "previous";

    private List<Entry> entries;
    private Summary summary;
    private Links links;

    public String next() { return links.getLinks().get(NEXT).toString(); }

    public String previous() { return links.getLinks().get(PREVIOUS).toString(); }

    public List<Entry> getEntries() { return entries; }

    public void setEntries(List<Entry> entries) { this.entries = entries; }

    public Summary getSummary() { return summary; }

    public void setSummary(Summary summary) { this.summary = summary; }

    @Override
    public String toString() {
        return new StringBuilder("EntriesListResponse{")
                .append("summary=").append(summary)
                .append(", entries=").append(entries)
                .append('}').toString();
    }
}
