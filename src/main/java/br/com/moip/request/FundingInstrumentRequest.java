package br.com.moip.request;

public class FundingInstrumentRequest {

    private Method method;
    private CreditCardRequest creditCard;
    private BoletoRequest boleto;
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

    public FundingInstrumentRequest boleto(final BoletoRequest boletoRequest) {
        this.boleto = boletoRequest;
        this.method = Method.BOLETO;

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
        CREDIT_CARD, DEBIT_CARD, BOLETO;
    }

    @Override
    public String toString() {
        return new StringBuilder("FundingInstrumentRequest{")
                .append("method=").append(method)
                .append(", creditCard=").append(creditCard)
                .append(", boleto=").append(boleto)
                .append('}').toString();
    }
}
