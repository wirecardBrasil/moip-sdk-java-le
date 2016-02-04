package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.BankAccountRequest;
import br.com.moip.resource.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccountsAPI {

    private final Client client;

    public BankAccountsAPI(final Client client) {
        this.client = client;
    }

    public BankAccount create(final String moipAccount, final BankAccountRequest bankAccountRequest) {
        BankAccount createdBankAccount = client.post("/v2/accounts/" + moipAccount + "/bankaccounts", bankAccountRequest, BankAccount.class);
        return createdBankAccount;
    }

    public BankAccount get(final String id) {
        BankAccount bankAccount = client.get("/v2/bankaccounts/" + id, BankAccount.class);
        return bankAccount;
    }

    public List<BankAccount> getList(final String moipAccount) {
        List<BankAccount> bankAccounts = client.get("/v2/accounts/" + moipAccount + "/bankaccounts", new ArrayList<BankAccount>().getClass());

        return bankAccounts;
    }

}
