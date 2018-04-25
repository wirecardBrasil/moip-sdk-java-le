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

    /*
     * Method to check an account existence.
     *
     * StatusCode   ResponseBody    Method's response
     * @200         200             true                Exist
     * @400         400             false               Invalid
     * @404         404             false               Does Not Exist
     */
    public Boolean checkAccountExists(String taxDocument) {
        try {
            client.get("/v2/accounts/exists?tax_document=" + taxDocument, String.class);

            return true;
        } catch (ValidationException e) { return false; }
    }
}
