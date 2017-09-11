package br.com.moip.request;

public class CreditCardRequest {

    private String hash;
    private String number;
    private String expirationMonth;
    private String expirationYear;
    private Integer cvc;
    private Boolean store;
    private HolderRequest holder;

    public String getHash() {
        return hash;
    }

    public CreditCardRequest hash(final String hash) {
        this.hash = hash;

        return this;
    }

    public String getNumber() {
        return number;
    }

    public CreditCardRequest number(final String number) {
        this.number = number;

        return this;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public CreditCardRequest expirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;

        return this;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public CreditCardRequest expirationYear(String expirationYear) {
        this.expirationYear = expirationYear;

        return this;
    }

    public Integer getCvc() {
        return cvc;
    }

    public CreditCardRequest cvc(Integer cvc) {
        this.cvc = cvc;

        return this;
    }

    public Boolean getStore() {
        return store;
    }

    public CreditCardRequest store(Boolean store) {
        this.store = store;

        return this;
    }

    public HolderRequest getHolder() {
        return holder;
    }

    public CreditCardRequest holder(final HolderRequest holder) {
        this.holder = holder;

        return this;
    }

    @Override
    public String toString() {
        return "CreditCardRequest{" +
                "hash='" + hash + '\'' +
                ", holder=" + holder +
                '}';
    }
}
