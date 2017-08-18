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

    public Account get(String accountId) {
        return client.get("/v2/accounts/" + accountId, Account.class);
    }

    public Account create(AccountRequest account) {
        return client.post("/v2/accounts", account, Account.class);
    }

    public Boolean checkAccountExists(String taxDocument) {
        Boolean accountExists = false;
        try {
            client.get("/v2/accounts/exists?tax_document=" + taxDocument, String.class);
            accountExists = true;
        } catch (ValidationException e) {
            if (e.getResponseCode() != 404) {
                throw new ValidationException(e.getResponseCode(), e.getResponseStatus(), e.getError());
            }
        }
        return accountExists;
    }


}
