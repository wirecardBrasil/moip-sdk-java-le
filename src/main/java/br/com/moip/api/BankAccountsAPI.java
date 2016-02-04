package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.BankAccountRequest;
import br.com.moip.resource.BankAccount;

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
        BankAccount bankAccount = client.get("v2/bankaccounts/" + id, BankAccount.class);
        return bankAccount;
    }

    public List<BankAccount> getAll(final String moipAccount) {
        List<BankAccount> bankAccounts = (List<BankAccount>) client.get("v2/accounts/" + moipAccount + "/bankaccounts", BankAccount.class);

        return bankAccounts;
    }

}
