package br.com.moip;

import br.com.moip.api.AccountAPI;
import br.com.moip.api.ConnectAPI;
import br.com.moip.api.CustomerAPI;
import br.com.moip.api.InvoiceAPI;
import br.com.moip.api.OrderAPI;
import br.com.moip.api.PaymentAPI;

public class API {

    private final Client client;

    public API(final Client client) {
        this.client = client;
    }

    public OrderAPI order() {
        return new OrderAPI(client);
    }

    public PaymentAPI payment() {
        return new PaymentAPI(client);
    }

    public InvoiceAPI invoice() {
        return new InvoiceAPI(client);
    }

    public AccountAPI account() {
        return new AccountAPI(client);
    }

    public CustomerAPI customer() {
        return new CustomerAPI(client);
    }

    public ConnectAPI connect() {
        return new ConnectAPI(new Client(Client.CONNECT_SANDBOX, client.getAuthentication()));
    }
}
