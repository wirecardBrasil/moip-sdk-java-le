package br.com.moip;


import br.com.moip.api.*;

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

    public PlugPagTokenAPI plugPagToken() { return new PlugPagTokenAPI(client); }

    public ConnectAPI connect() {
        if (client.getEndpoint() == Client.PRODUCTION) {
            return new ConnectAPI(new Client(Client.CONNECT_PRODUCTION, client.getAuthentication()));
        }

        return new ConnectAPI(new Client(Client.CONNECT_SANDBOX, client.getAuthentication()));
    }

    public NotificationPreferencesAPI notification() {
        return new NotificationPreferencesAPI(client);
    }

    public RefundAPI refund() {
        return new RefundAPI(client);
    }

    public MultiorderAPI multiorder(){
        return new MultiorderAPI(client);
    }

    public MultipaymentAPI multipayment() {
        return new MultipaymentAPI(client);
    }

    public BankAccountsAPI bankAccount() {
        return new BankAccountsAPI(client);
    }

    public EscrowAPI escrow() {
        return new EscrowAPI(client);
    }

    public TransferApi transfer() {
        return new TransferApi(client);
    }

    public EntryAPI entry() { return new EntryAPI(client); }

    public BalancesAPI balance() { return new BalancesAPI(client); }
}
