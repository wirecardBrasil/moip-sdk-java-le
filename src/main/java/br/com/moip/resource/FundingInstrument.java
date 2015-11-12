package br.com.moip.resource;

public class FundingInstrument {
    private boolean supressCreditCard;
    private boolean supressBoleto;
    private Method method;
    private CreditCard creditCard;

    public boolean isSupressCreditCard() {
        return supressCreditCard;
    }

    public FundingInstrument setSupressCreditCard(boolean supressCreditCard) {
        this.supressCreditCard = supressCreditCard;
        return this;
    }

    public boolean isSupressBoleto() {
        return supressBoleto;
    }

    public FundingInstrument setSupressBoleto(boolean supressBoleto) {
        this.supressBoleto = supressBoleto;
        return this;
    }

    public Method getMethod() {
        return method;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public FundingInstrument setCreditCard(final CreditCard creditCard) {
        this.creditCard = creditCard;
        this.method = Method.CREDIT_CARD;

        return this;
    }

    @Override
    public String toString() {
        return "FundingInstrument{" +
                "supressCreditCard=" + supressCreditCard +
                ", supressBoleto=" + supressBoleto +
                '}';
    }

    private enum Method {
        CREDIT_CARD;
    }
}