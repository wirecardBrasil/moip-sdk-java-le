package br.com.moip.request;

public class FundingInstrumentRequest {

    private Method method;
    private CreditCardRequest creditCard;
    private DebitCardRequest debitCard;
    private BoletoRequest boleto;
    private MposRequest mpos;
    private OnlineBankDebitRequest onlineBankDebit;
    private boolean suppressBoleto;
    private boolean suppressCreditCard;

    public FundingInstrumentRequest creditCard(final CreditCardRequest creditCard) {
        this.creditCard = creditCard;
        this.method = Method.CREDIT_CARD;
        return this;
    }

    private FundingInstrumentRequest debitCard(final DebitCardRequest debitCard) {
        this.debitCard = debitCard;
        this.method = Method.DEBIT_CARD;
        return this;
    }

    public FundingInstrumentRequest boleto(final BoletoRequest boletoRequest) {
        this.boleto = boletoRequest;
        this.method = Method.BOLETO;
        return this;
    }

    public FundingInstrumentRequest mposDebitCard(final MposRequest mposRequest, final DebitCardRequest debitCard) {
        this.mpos = mposRequest;
        this.debitCard(debitCard);
        return this;
    }

    public FundingInstrumentRequest mposCreditCard(final MposRequest mposRequest, final CreditCardRequest creditCard) {
        this.mpos = mposRequest;
        this.creditCard(creditCard);
        return this;
    }

    public FundingInstrumentRequest onlineBankDebit(final OnlineBankDebitRequest onlineBankDebit) {
        this.onlineBankDebit = onlineBankDebit;
        this.method = Method.ONLINE_BANK_DEBIT;
        return this;
    }

    public FundingInstrumentRequest suppressBoleto(final boolean supressBoleto) {
        this.suppressBoleto = supressBoleto;
        return this;
    }

    public FundingInstrumentRequest suppressCreditCard(final boolean supressCreditCard) {
        this.suppressCreditCard = supressCreditCard;
        return this;
    }

    public boolean isSuppressBoleto() {
        return suppressBoleto;
    }

    public boolean isSuppressCreditCard() {
        return suppressCreditCard;
    }

    public Method getMethod() {
        return method;
    }

    public CreditCardRequest getCreditCard() {
        return creditCard;
    }

    public BoletoRequest getBoleto() {
        return boleto;
    }

    public DebitCardRequest getDebitCard() {
        return debitCard;
    }

    public MposRequest getMpos() {
        return mpos;
    }

    public OnlineBankDebitRequest getOnlineBankDebit() {
        return onlineBankDebit;
    }

    private enum Method {
        CREDIT_CARD, DEBIT_CARD, BOLETO, ONLINE_BANK_DEBIT;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FundingInstrumentRequest{");
        sb.append("method=").append(method);
        sb.append(", creditCard=").append(creditCard);
        sb.append(", boleto=").append(boleto);
        sb.append(", suppressBoleto=").append(suppressBoleto);
        sb.append(", suppressCreditCard=").append(suppressCreditCard);
        sb.append(", onlineBankDebit=").append(onlineBankDebit);
        sb.append(", mpos=").append(mpos);
        sb.append('}');
        return sb.toString();
    }
}
