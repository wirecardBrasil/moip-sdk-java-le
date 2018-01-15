package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.api.filter.Filters;
import br.com.moip.api.filter.Pagination;
import br.com.moip.resource.Entry;
import br.com.moip.response.EntriesListResponse;
import br.com.moip.util.QueryStringFactory;

import java.util.HashMap;
import java.util.Map;

public class EntryAPI {

    private final Client client;

    private static final String PATH = "/v2/entries";

    public EntryAPI(final Client client) { this.client = client; }

    public Entry get(String externalId) { return client.get(String.format("%s/%s", PATH, externalId), Entry.class); }

    public EntriesListResponse list() { return client.get(PATH, EntriesListResponse.class); }

    public EntriesListResponse list(final Pagination pagination) {
        return client.get(new QueryStringFactory(PATH, pagination, null, null).generate(), EntriesListResponse.class);
    }

    public EntriesListResponse list(final Filters filter) {
        return client.get(new QueryStringFactory(PATH, null, filter, null).generate(), EntriesListResponse.class);
    }

    public EntriesListResponse list(final String queryParam) {
        return client.get(new QueryStringFactory(PATH, null, null, hashParams(queryParam)).generate(), EntriesListResponse.class);
    }

    public EntriesListResponse list(final Pagination pagination, final Filters filters) {
        return client.get(new QueryStringFactory(PATH, pagination, filters, null).generate(), EntriesListResponse.class);
    }

    public EntriesListResponse list(final Pagination pagination, String queryParam) {
        return client.get(new QueryStringFactory(PATH, pagination, null, hashParams(queryParam)).generate(), EntriesListResponse.class);
    }

    public EntriesListResponse list(final Filters filters, final String queryParam) {
        return client.get(new QueryStringFactory(PATH, null, filters, hashParams(queryParam)).generate(), EntriesListResponse.class);
    }

    public EntriesListResponse list(final Pagination pagination, final Filters filters, final String queryParam) {
        return client.get(new QueryStringFactory(PATH, pagination,filters, hashParams(queryParam)).generate(), EntriesListResponse.class);
    }

    private Map<String, String> hashParams(final String queryParam) {
        return new HashMap<String, String>() {{
            put("q", queryParam);
        }};
    }
}