package br.com.moip.resource;

public class CreditCard {

    private String hash;
    private Holder holder;

    //Used on MPOS
    private String brand;
    private String first6;
    private String last4;
    private CaptureMethod captureMethod;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFirst6() {
        return first6;
    }

    public void setFirst6(String first6) {
        this.first6 = first6;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public CaptureMethod getCaptureMethod() {
        return captureMethod;
    }

    public void setCaptureMethod(CaptureMethod captureMethod) {
        this.captureMethod = captureMethod;
    }
}
