package br.com.moip.resource;

public class CreditCard {

    private Holder holder;

    private Boolean store;

    private String id;
    //Used on MPOS
    private String brand;
    private String first6;
    private String last4;
    private String expirationMonth;
    private String expirationYear;

    public String getId() {
        return id;
    }

    public Holder getHolder() {
        return holder;
    }

    public Boolean getStore() {
        return store;
    }

    public String getBrand() {
        return brand;
    }

    public String getFirst6() {
        return first6;
    }

    public String getLast4() {
        return last4;
    }

    public String getExpirationMonth(){
        return expirationMonth;
    }

    public String getExpirationYear(){
        return expirationYear;
    }

    @Override
    public String toString() {
        return new StringBuilder("CreditCard{")
                .append("holder=").append(holder)
                .append(", brand='").append(brand).append('\'')
                .append(", first6='").append(first6).append('\'')
                .append(", last4='").append(last4).append('\'')
                .append(", store=").append(store)
                .append('}').toString();
    }
}
