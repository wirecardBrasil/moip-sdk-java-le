package br.com.moip.resource.links;

public class OrderLinks {

    private Href self;
    private Checkout checkout;

    public String getSelf() {
        return self.getHref();
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public String payCheckout() { return checkout.getPayCheckout().getRedirectHref(); }

    public String payCreditCard() {
        return checkout.getPayCreditCard().getRedirectHref();
    }

    public String payBoleto() {
        return checkout.getPayBoleto().getRedirectHref();
    }

    public String payOnlineBankDebitItau() {
        return checkout.getPayOnlineBankDebitItau().getRedirectHref();
    }

    @Override
    public String toString() {
        return new StringBuilder("OrderLinks{")
            .append("self=").append(self)
            .append(", checkout=").append(checkout)
            .append('}').toString();
    }
}
