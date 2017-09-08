package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.CustomerRequest;
import br.com.moip.resource.Customer;
import br.com.moip.resource.FundingInstrument;

public class CustomerAPI {

    private final Client client;

    public CustomerAPI(Client client) {
        this.client = client;
    }

    public Customer create(CustomerRequest customer) {
        return client.post("/v2/customers", customer, Customer.class);
    }

    public Customer get(String externalId) {
        return client.get("/v2/customers/" + externalId, Customer.class);
    }

    public FundingInstrument addCreditCard (CustomerRequest customer) {
        return client.post("/v2/customers/" + customer.getId() + "/fundinginstruments", customer.getFundingInstrument(), FundingInstrument.class);
    }

    public Boolean deleteCreditCard (String creditCardId) {
        try {
            client.delete("/v2/fundinginstruments/" + creditCardId, FundingInstrument.class);

            return true;
        } catch (ValidationException e) {
            if (e.getResponseCode() != 404) {
                throw new ValidationException(e.getResponseCode(), e.getResponseStatus(), e.getError());
            }
        }

        return false;
    }
}
