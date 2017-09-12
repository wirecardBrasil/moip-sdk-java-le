package br.com.moip.request;

public class RefundingInstrumentRequest {

    private Method method;
    private BankAccountRequest bankAccount;

    public RefundingInstrumentRequest bankAccount(BankAccountRequest bankAccount) {
        this.method = Method.BANK_ACCOUNT;
        this.bankAccount = bankAccount;

        return this;
    }

    public RefundingInstrumentRequest moipAccount() {
        this.method = Method.MOIP_ACCOUNT;

        return this;
    }

    public RefundingInstrumentRequest creditCard() {
        this.method = Method.CREDIT_CARD;

        return this;
    }

    private enum Method {
        CREDIT_CARD, BANK_ACCOUNT, MOIP_ACCOUNT
    }

    @Override
    public String toString() {
        return new StringBuilder("RefundingInstrumentRequest{")
            .append("method=").append(method)
            .append("bankAccount=").append(bankAccount)
            .append("}").toString();
    }
}
