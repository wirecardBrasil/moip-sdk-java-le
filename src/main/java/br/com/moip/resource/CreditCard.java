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
        final StringBuilder sb = new StringBuilder("CreditCard{");
        sb.append("holder=").append(holder);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", first6='").append(first6).append('\'');
        sb.append(", last4='").append(last4).append('\'');
        sb.append(", captureMethod=").append(captureMethod);
        sb.append('}');
        return sb.toString();
    }
}
