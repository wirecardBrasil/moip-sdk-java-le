package br.com.moip.examples;

import br.com.moip.API;
import br.com.moip.api.filter.Filters;
import br.com.moip.api.filter.Pagination;
import br.com.moip.examples.setup.Setup;
import br.com.moip.resource.Entry;
import br.com.moip.response.EntriesListResponse;
import org.junit.Test;

public class EntryExamples {

    // API instance
    API api = new Setup().buildSetup();

    // OKAY
    public void getEntry() {

        Entry entry = api.entry().get("ENT-2JHP5A593QSW");
    }

    // OKAY
    public void listEntries() {

        EntriesListResponse entriesListResponse = api.entry().list();
    }

    // OKAY
    public void listEntriesWithSearchParams() {

        Pagination pagination = new Pagination();
        pagination.setLimit(10);
        pagination.setOffset(10);

        Filters filters = new Filters();
        filters.between("liquidAmount", "5000", "50000");

        String q = "SETTLED";

        EntriesListResponse entriesListResponse = api.entry().list(pagination, filters, q);
    }
}
