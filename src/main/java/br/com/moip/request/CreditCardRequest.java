package br.com.moip.request;


public class CreditCardRequest {

    private String id;
    private String publicKey;
    private String number;
    private String cvc;
    private String expirationMonth;
    private String expirationYear;
    private String hash;
    private HolderRequest holder;

    public String getHash() {
        return hash;
    }

    public CreditCardRequest hash(final String hash) {
        this.hash = hash;

        return this;
    }

    public HolderRequest getHolder() {
        return holder;
    }

    public CreditCardRequest holder(final HolderRequest holder) {
        this.holder = holder;

        return this;
    }

    public CreditCardRequest id(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return this.id;
    }


    public CreditCardRequest publicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public CreditCardRequest cardNumber(String number) {
        this.number = number;
        return this;
    }

    public CreditCardRequest cvc(String cvc) {
        this.cvc = cvc;
        return this;
    }

    public CreditCardRequest expirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
        return this;
    }

    public CreditCardRequest expirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public String getCvc() {
        return cvc;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreditCardRequest{");
        sb.append("id='").append(id).append('\'');
        sb.append(", publicKey='").append(publicKey).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append(", cvc='").append(cvc).append('\'');
        sb.append(", expirationMonth='").append(expirationMonth).append('\'');
        sb.append(", expirationYear='").append(expirationYear).append('\'');
        sb.append(", hash='").append(hash).append('\'');
        sb.append(", holder=").append(holder);
        sb.append('}');
        return sb.toString();
    }
}
