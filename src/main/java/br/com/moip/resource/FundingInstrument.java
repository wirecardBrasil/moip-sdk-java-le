package br.com.moip.resource;

public class FundingInstrument {
    private boolean supressCreditCard;
    private boolean supressBoleto;
    private Method method;
    private CreditCard creditCard;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FundingInstrument{");
        sb.append("supressCreditCard=").append(supressCreditCard);
        sb.append(", supressBoleto=").append(supressBoleto);
        sb.append(", method=").append(method);
        sb.append(", creditCard=").append(creditCard);
        sb.append('}');
        return sb.toString();
    }

    private enum Method {
        CREDIT_CARD;
    }
}