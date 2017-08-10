package br.com.moip.request;

public class OnlineBankDebitRequest {

    private String bankNumber;
    private ApiDateRequest expirationDate;
    private String returnUri;

    public ApiDateRequest getExpirationDate() {
        return expirationDate;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public String getReturnUri() {
        return returnUri;
    }

    public OnlineBankDebitRequest expirationDate(final ApiDateRequest expirationDate) {
        this.expirationDate = expirationDate;

        return this;
    }

    public OnlineBankDebitRequest bankNumber(final String bankNumber) {
        this.bankNumber = bankNumber;

        return this;
    }

    public OnlineBankDebitRequest returnUri(final String returnUri) {
        this.returnUri = returnUri;

        return this;
    }
}
