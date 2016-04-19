package br.com.moip.resource;

public class FundingInstrument {
    private boolean supressCreditCard;
    private boolean supressBoleto;
    private Method method;
    private CreditCard creditCard;
    private Boleto boleto;

    public boolean isSupressCreditCard() {
        return supressCreditCard;
    }

    public boolean isSupressBoleto() {
        return supressBoleto;
    }

    public FundingInstrument setSupressBoleto(final boolean supressBoleto) {
        this.supressBoleto = supressBoleto;

        return this;
    }

    public Method getMethod() {
        return method;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    @Override
    public String toString() {
        return new StringBuilder("FundingInstrument{")
                .append("supressCreditCard=").append(supressCreditCard)
                .append(", supressBoleto=").append(supressBoleto)
                .append(", method=").append(method)
                .append(", creditCard=").append(creditCard)
                .append('}').toString();
    }

    public enum Method {
        CREDIT_CARD, BOLETO;
    }
}
