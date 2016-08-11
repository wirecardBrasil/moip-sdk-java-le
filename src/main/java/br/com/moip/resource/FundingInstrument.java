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

    public enum Method {
        CREDIT_CARD, BOLETO;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FundingInstrument{");
        sb.append("supressCreditCard=").append(supressCreditCard);
        sb.append(", supressBoleto=").append(supressBoleto);
        sb.append(", method=").append(method);
        sb.append(", creditCard=").append(creditCard);
        sb.append(", boleto=").append(boleto);
        sb.append(", mpos=").append(mpos);
        sb.append('}');
        return sb.toString();
    }
}
