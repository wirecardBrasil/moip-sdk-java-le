package br.com.moip.resource.links;

public class Checkout {

    private RedirectHref payCheckout;
    private RedirectHref payCreditCard;
    private PayBoleto payBoleto;
    private RedirectHref payOnlineBankDebitItau;

    public String getPayCheckoutHref() {
        return payCheckout.getRedirectHref();
    }

    public String getPayCreditCardHref() {
        return payCreditCard.getRedirectHref();
    }

    public String getPayBoletoLink() {
        return payBoleto.getRedirectHref();
    }

    public String getPayBoletoPrintLink() { return payBoleto.getPrintHref(); }

    public String getPayOnlineBankDebitItauHref() {
        return payOnlineBankDebitItau.getRedirectHref();
    }

    public RedirectHref getPayCheckout() { return payCheckout; }

    public RedirectHref getPayCreditCard() { return payCreditCard; }

    public PayBoleto getPayBoleto() { return payBoleto; }

    public RedirectHref getPayOnlineBankDebitItau() { return payOnlineBankDebitItau; }

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