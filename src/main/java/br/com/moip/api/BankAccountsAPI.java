package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.BankAccountRequest;
import br.com.moip.resource.BankAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankAccountsAPI {

    private final Client client;

    public BankAccountsAPI(final Client client) {
        this.client = client;
    }

    public BankAccount create(final String moipAccount, final BankAccountRequest bankAccountRequest) {
        return client.post("/v2/accounts/" + moipAccount + "/bankaccounts", bankAccountRequest, BankAccount.class);
    }

    public BankAccount get(final String id) {
        return client.get("/v2/bankaccounts/" + id, BankAccount.class);
    }

    public List<BankAccount> getList(final String moipAccount) {
        BankAccount[] bankAccounts = client.get("/v2/accounts/" + moipAccount + "/bankaccounts", BankAccount[].class);

        return Arrays.asList(bankAccounts);
    }

}
