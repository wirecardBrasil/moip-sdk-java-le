package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.AccountRequest;
import br.com.moip.resource.Account;

public class AccountAPI {

    private final Client client;

    public AccountAPI(final Client client) {
        this.client = client;
    }

    public Account get() {
        return client.get("/v2/accounts", Account.class);
    }

    public Account create(AccountRequest account) {
        return client.post("/v2/accounts", account, Account.class);
    }

    public Boolean checkAccountExists(String taxDocument) {
        Boolean accountExists = true;
        try {
            Integer statusCode = client.get("/v2/accounts/exists?tax_document=" + taxDocument, Integer.class);
            if (statusCode != 200) {
                accountExists = false;
            }
        } catch (ValidationException e) {
            if (e.getResponseCode() == 404) {
                accountExists = false;
            }
        }

        return accountExists;
    }


}
