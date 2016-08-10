package br.com.moip.request;

public class FundingInstrumentRequest {

    private Method method;
    private CreditCardRequest creditCard;
    private BoletoRequest boleto;
    private boolean supressBoleto;
    private boolean supressCreditCard;
    private MposRequest mpos;


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

    public FundingInstrumentRequest mposDebitCard(final MposRequest mposRequest) {
        this.mpos = mposRequest;
        this.method = Method.DEBIT_CARD;
        return this;
    }

    public FundingInstrumentRequest mposCreditCard(final MposRequest mposRequest) {
        this.mpos = mposRequest;
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

    private enum Method {
        CREDIT_CARD, DEBIT_CARD, BOLETO;
    }

    public MposRequest getMpos() {
        return mpos;
    }

    public void setMpos(MposRequest mpos) {
        this.mpos = mpos;
    }

    @Override
    public String toString() {
        return "FundingInstrumentRequest{" +
                "method=" + method +
                ", creditCard=" + creditCard +
                ", boleto=" + boleto +
                ", supressBoleto=" + supressBoleto +
                ", supressCreditCard=" + supressCreditCard +
                ", mpos=" + mpos +
                '}';
    }
}
