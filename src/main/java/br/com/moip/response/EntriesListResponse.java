package br.com.moip.response;

import br.com.moip.resource.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntriesListResponse extends ArrayList<Entry> {

    private List<Entry> entries;

    @Override
    public String toString() {
        return new StringBuilder("EntriesListResponse=[")
                .append(entries)
                .append(']').toString();
    }
}
