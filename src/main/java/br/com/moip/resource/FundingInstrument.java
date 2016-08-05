package br.com.moip.resource;

public class FundingInstrument {
    private boolean supressCreditCard;
    private boolean supressBoleto;
    private Method method;
    private CreditCard creditCard;
    private Boleto boleto;
    private Mpos mpos;

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

    public Mpos getMpos() {
        return mpos;
    }

    public void setMpos(Mpos mpos) {
        this.mpos = mpos;
    }

    public enum Method {
        CREDIT_CARD, BOLETO;
    }

    @Override
    public String toString() {
        return "FundingInstrument{" +
                "supressCreditCard=" + supressCreditCard +
                ", supressBoleto=" + supressBoleto +
                ", method=" + method +
                ", creditCard=" + creditCard +
                ", boleto=" + boleto +
                ", mpos=" + mpos +
                '}';
    }
}
