package br.com.moip.request;

public class CreditCardRequest {

    private String hash;
    private HolderRequest holder;

    //Used on MPOS
    private String brand;
    private String first6;
    private String last4;
    private CaptureMethodRequest captureMethodRequest;

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
        final StringBuilder sb = new StringBuilder("CreditCardRequest{");
        sb.append("hash='").append(hash).append('\'');
        sb.append(", holder=").append(holder);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", first6='").append(first6).append('\'');
        sb.append(", last4='").append(last4).append('\'');
        sb.append(", captureMethodRequest=").append(captureMethodRequest);
        sb.append('}');
        return sb.toString();
    }
}
