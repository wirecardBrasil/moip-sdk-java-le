package br.com.moip.resource.links;

public class Checkout {

    private RedirectHref payCheckout;
    private RedirectHref payCreditCard;
    private RedirectHref payBoleto;
    private RedirectHref payOnlineBankDebitItau;

    public String getPayCheckout() {
        return payCheckout.getRedirectHref();
    }

    public String getPayCreditCard() {
        return payCreditCard.getRedirectHref();
    }

    public String getPayBoleto() {
        return payBoleto.getRedirectHref();
    }

    public String getPayOnlineBankDebitItau() {
        return payOnlineBankDebitItau.getRedirectHref();
    }

    @Override
    public String toString() {
        return new StringBuilder("Checkout{")
                .append("payCheckout=").append(payCheckout)
                .append(", payCreditCard=").append(payCreditCard)
                .append(", payBoleto=").append(payBoleto)
                .append(", payOnlineBankDebitItau=").append(payOnlineBankDebitItau)
                .append("}").toString();
    }
}