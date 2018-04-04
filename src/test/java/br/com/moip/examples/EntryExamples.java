package br.com.moip.examples;

import br.com.moip.API;
import br.com.moip.api.filter.Filters;
import br.com.moip.api.filter.Pagination;
import br.com.moip.examples.setup.Setup;
import br.com.moip.resource.Entry;
import br.com.moip.response.EntriesListResponse;
import org.junit.Test;

public class EntryExamples {

    /**
     * The Moip entry is a credit or debit in the statement
     * or in the future balance of a receiver account.
     * It's generated when a payment is authorized, a refund is requested
     * or any other situation in which the values movement occurs
     * in the seller's Moip account.
     *
     * This API uses [application/json;version=2.1].
     * For more information, check the fallowing link:
     * https://dev.moip.com.br/v2/reference#lan%C3%A7amentos-1
     */

    // API instance
    API api = new Setup().buildSetup();

    // This method allows you to get a entry.
    public void getEntry() {

        Entry entry = api.entry().get("ENT-2JHP5A593QSW");
    }

    // This method list all open entries.
    public void listEntries() {

        EntriesListResponse entriesListResponse = api.entry().list();
    }

    // To improve your search, you can add some parameters to filter your request.
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
