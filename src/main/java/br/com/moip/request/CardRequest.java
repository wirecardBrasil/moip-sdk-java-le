package br.com.moip.request;

//Used on MPOS
public class CardRequest {

    private HolderRequest holder;
    private String brand;
    private String first6;
    private String last4;
    private CaptureMethodRequest captureMethodRequest;

    public HolderRequest getHolder() {
        return holder;
    }

    public void holder(HolderRequest holder) {
        this.holder = holder;
    }

    public String getBrand() {
        return brand;
    }

    public void brand(String brand) {
        this.brand = brand;
    }

    public String getFirst6() {
        return first6;
    }

    public void first6(String first6) {
        this.first6 = first6;
    }

    public String getLast4() {
        return last4;
    }

    public void last4(String last4) {
        this.last4 = last4;
    }

    public CaptureMethodRequest getCaptureMethodRequest() {
        return captureMethodRequest;
    }

    public void captureMethodRequest(CaptureMethodRequest captureMethodRequest) {
        this.captureMethodRequest = captureMethodRequest;
    }

    @Override
    public String toString() {
        return "CardRequest{" +
                "holder=" + holder +
                ", brand='" + brand + '\'' +
                ", first6='" + first6 + '\'' +
                ", last4='" + last4 + '\'' +
                ", captureMethodRequest=" + captureMethodRequest +
                '}';
    }
}
