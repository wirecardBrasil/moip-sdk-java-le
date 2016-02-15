package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.api.filter.Pagination;
import br.com.moip.resource.BankAccount;
import br.com.moip.resource.Transfer;
import br.com.moip.response.InvoiceListResponse;
import br.com.moip.response.TransferListResponse;

import java.util.Arrays;
import java.util.List;

public class TransferApi {

    private final Client client;

    public TransferApi(final Client client) {
        this.client = client;
    }

    public Transfer get(final String id) {
        Transfer transfer = client.get("/v2/transfers/" + id, Transfer.class);
        return transfer;
    }

    public TransferListResponse getList() {
        return client.get("/v2/transfers", TransferListResponse.class);
    }

    public TransferListResponse getList(final Pagination pagination) {
        if (pagination.getLimit() == 0)
            return client.get("/v2/transfers", TransferListResponse.class);
        if (pagination.getOffset() <= 0)
            return client.get("/v2/transfers?limit=" + pagination.getLimit(), TransferListResponse.class);
        return client.get("/v2/transfers?limit=" + pagination.getLimit() + "&offset=" + pagination.getOffset(), TransferListResponse.class);
    }


}
