package br.com.moip.request;

//Used on MPOS
public class CardRequest {

    private HolderRequest holder;
    private String brand;
    private String first6;
    private String last4;
    private CaptureMethodRequest captureMethod;

    public HolderRequest getHolder() {
        return holder;
    }

    public CardRequest holder(HolderRequest holder) {
        this.holder = holder;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CardRequest brand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getFirst6() {
        return first6;
    }

    public CardRequest first6(String first6) {
        this.first6 = first6;
        return this;
    }

    public String getLast4() {
        return last4;
    }

    public CardRequest last4(String last4) {
        this.last4 = last4;
        return this;
    }

    public CaptureMethodRequest getCaptureMethod() {
        return captureMethod;
    }

    public CardRequest captureMethodRequest(CaptureMethodRequest captureMethodRequest) {
        this.captureMethod = captureMethodRequest;
        return this;
    }

    @Override
    public String toString() {
        return "CardRequest{" +
                "holder=" + holder +
                ", brand='" + brand + '\'' +
                ", first6='" + first6 + '\'' +
                ", last4='" + last4 + '\'' +
                ", captureMethod=" + captureMethod +
                '}';
    }
}
