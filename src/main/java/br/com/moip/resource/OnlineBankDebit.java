package br.com.moip.resource;

public class OnlineBankDebit {

    private String bankNumber;
    private ApiDate expirationDate;
    private String returnUri;

    public String getBankNumber() {
        return bankNumber;
    }

    public OnlineBankDebit setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;

        return this;
    }

    public ApiDate getExpirationDate() {
        return expirationDate;
    }

    public OnlineBankDebit setExpirationDate(ApiDate expirationDate) {
        this.expirationDate = expirationDate;

        return this;
    }

    public String getReturnUri() {
        return returnUri;
    }

    public OnlineBankDebit setReturnUri(String returnUri) {
        this.returnUri = returnUri;

        return this;
    }
}
