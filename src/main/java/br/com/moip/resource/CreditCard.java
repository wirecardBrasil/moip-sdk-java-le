package br.com.moip.resource;

public class CreditCard {

    private String hash;
    private Holder holder;

    public String getHash() {
        return hash;
    }

    public CreditCard setHash(String hash) {
        this.hash = hash;

        return this;
    }

    public Holder getHolder() {
        return holder;
    }

    public CreditCard setHolder(Holder holder) {
        this.holder = holder;

        return this;
    }
}
