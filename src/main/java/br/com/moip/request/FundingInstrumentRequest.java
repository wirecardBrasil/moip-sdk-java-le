package br.com.moip.request;

public class FundingInstrumentRequest {

    private Method method;
    private CreditCardRequest creditCard;
    private boolean supressBoleto;
    private boolean supressCreditCard;
    //Used on MPOS
    private CardRequest card;


    public Method getMethod() {
        return method;
    }

    public FundingInstrumentRequest creditCard(final CreditCardRequest creditCard) {
        this.creditCard = creditCard;
        this.method = Method.CREDIT_CARD;

        return this;
    }

    public FundingInstrumentRequest mposDebitCard(final CardRequest debitCard) {
        this.card = debitCard;
        this.method = Method.DEBIT_CARD;
        return this;
    }

    public FundingInstrumentRequest mposCreditCard(final CardRequest creditCard) {
        this.card = creditCard;
        this.method = Method.CREDIT_CARD;
        return this;
    }

    public boolean isSupressBoleto() {
        return supressBoleto;
    }

    public FundingInstrumentRequest supressBoleto(final boolean supressBoleto) {
        this.supressBoleto = supressBoleto;

        return this;
    }

    public boolean isSupressCreditCard() {
        return supressCreditCard;
    }

    public FundingInstrumentRequest supressCreditCard(final boolean supressCreditCard) {
        this.supressCreditCard = supressCreditCard;

        return this;
    }

    public CardRequest getCard() {
        return card;
    }

    private enum Method {
        CREDIT_CARD, DEBIT_CARD;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FundingInstrumentRequest{");
        sb.append("method=").append(method);
        sb.append(", creditCard=").append(creditCard);
        sb.append('}');
        return sb.toString();
    }
}
