package br.com.moip.resource;

import com.google.gson.annotations.SerializedName;

public class Checkout {

    @SerializedName("payCheckout") private PayLink payCheckout;
    @SerializedName("payCreditCard") private PayLink payCreditCard;
    @SerializedName("payBoleto") private PayLink payBoleto;
    @SerializedName("payOnlineBankDebitItau") private PayLink payOnlineBankDebitItau;

    public PayLink getPayCheckout() {
        return payCheckout;
    }

    public void setPayCheckout(PayLink payCheckout) {
        this.payCheckout = payCheckout;
    }

    public PayLink getPayCreditCard() {
        return payCreditCard;
    }

    public void setPayCreditCard(PayLink payCreditCard) {
        this.payCreditCard = payCreditCard;
    }

    public PayLink getPayBoleto() {
        return payBoleto;
    }

    public void setPayBoleto(PayLink payBoleto) {
        this.payBoleto = payBoleto;
    }

    public PayLink getPayOnlineBankDebitItau() {
        return payOnlineBankDebitItau;
    }

    public void setPayOnlineBankDebitItau(PayLink payOnlineBankDebitItau) {
        this.payOnlineBankDebitItau = payOnlineBankDebitItau;
    }

    @Override
    public String toString() {
        return new StringBuilder("Checkout{")
                .append("payCheckout=").append(payCheckout)
                .append(", payCreditCard=").append(payCreditCard)
                .append(", payBoleto=").append(payBoleto)
                .append(", payOnlineBankDebitItau=").append(payOnlineBankDebitItau)
                .append('}').toString();
    }
    
    public static final class PayLink {
        @SerializedName("redirectHref") private String redirectHref;

        public String getRedirectHref() {
            return redirectHref;
        }

        public void setRedirectHref(String redirectHref) {
            this.redirectHref = redirectHref;
        }

        @Override
        public String toString() {
            return new StringBuilder("PayLink{")
                    .append("redirectHref='").append(redirectHref).append("\'").toString();
        }
    }
}
