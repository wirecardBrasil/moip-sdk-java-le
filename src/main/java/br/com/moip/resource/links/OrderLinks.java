package br.com.moip.resource.links;

public class OrderLinks {

    private Href self;
    private Checkout checkout;

    public String self() {
        return self.getHref();
    }

    public String payCheckout() {
        return checkout.getPayCheckout().getRedirectHref();
    }

    public String payCreditCard() {
        return checkout.getPayCreditCard().getRedirectHref();
    }

    public String payBoleto() {
        return checkout.getPayBoleto().getRedirectHref();
    }

    public String payOnlineBankDebitItau() {
        return checkout.getPayOnlineBankDebitItau().getRedirectHref();
    }

    public Href getLink() {
        return self;
    }
    public Checkout getCheckout() {
        return checkout;
    }

    @Override
    public String toString() {
        return new StringBuilder("OrderLinks{")
            .append("self=").append(self)
            .append(", checkout=").append(checkout)
            .append('}').toString();
    }
}
