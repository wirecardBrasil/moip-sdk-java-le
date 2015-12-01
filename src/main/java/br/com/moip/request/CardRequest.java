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

    public void setHolder(HolderRequest holder) {
        this.holder = holder;
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

    public CaptureMethodRequest getCaptureMethodRequest() {
        return captureMethodRequest;
    }

    public void setCaptureMethodRequest(CaptureMethodRequest captureMethodRequest) {
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
