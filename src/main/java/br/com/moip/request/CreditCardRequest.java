package br.com.moip.request;

public class CreditCardRequest {

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

    @Override
    public String toString() {
        return "CreditCardRequest{" +
                "hash='" + hash + '\'' +
                ", holder=" + holder +
                '}';
    }
}
