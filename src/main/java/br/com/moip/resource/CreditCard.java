package br.com.moip.resource;

public class CreditCard {

    private Holder holder;

    //Used on MPOS
    private String brand;
    private String first6;
    private String last4;
    private CaptureMethod captureMethod;

    public Holder getHolder() {
        return holder;
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

    public CaptureMethod getCaptureMethod() {
        return captureMethod;
    }

    @Override
    public String toString() {
        return new StringBuilder("CreditCard{")
                .append("holder=").append(holder)
                .append(", brand='").append(brand).append('\'')
                .append(", first6='").append(first6).append('\'')
                .append(", last4='").append(last4).append('\'')
                .append(", captureMethod=").append(captureMethod)
                .append('}').toString();
    }
}
