package br.com.moip.resource.links;

public class Checkout {

    private RedirectHref payCheckout;
    private RedirectHref payCreditCard;
    private RedirectHref payBoleto;
    private RedirectHref payOnlineBankDebitItau;

    public RedirectHref getPayCheckout() {
        return payCheckout;
    }

    public RedirectHref getPayCreditCard() {
        return payCreditCard;
    }

    public RedirectHref getPayBoleto() {
        return payBoleto;
    }

    public RedirectHref getPayOnlineBankDebitItau() {
        return payOnlineBankDebitItau;
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