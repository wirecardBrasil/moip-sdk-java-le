package br.com.moip.request;

public class PaymentRequest {

    private String orderId;
    private int installmentCount;
    private FundingInstrumentRequest fundingInstrument = new FundingInstrumentRequest();
    private GeolocationRequest geolocation;
    private Boolean delayCapture;

    public PaymentRequest orderId(final String orderId) {
        this.orderId = orderId;
        return this;
    }

    public PaymentRequest installmentCount(final int installmentCount) {
        this.installmentCount = installmentCount;
        return this;
    }

    public PaymentRequest fundingInstrument(final FundingInstrumentRequest fundingInstrument) {
        this.fundingInstrument = fundingInstrument;
        return this;
    }

    public PaymentRequest geolocation(GeolocationRequest geolocation){
        this.geolocation = geolocation;
        return this;
    }

    public PaymentRequest delayCapture(Boolean delayCapture) {
        this.delayCapture = delayCapture;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public FundingInstrumentRequest getFundingInstrument() {
        return fundingInstrument;
    }

    public GeolocationRequest getGeolocation() {
        return geolocation;
    }

    public Boolean getDelayCapture() {
        return delayCapture;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentRequest{");
        sb.append("orderId='").append(orderId).append('\'');
        sb.append(", installmentCount=").append(installmentCount);
        sb.append(", fundingInstrument=").append(fundingInstrument);
        sb.append(", geolocation=").append(geolocation);
        sb.append(", delayCapture=").append(delayCapture);
        sb.append('}');
        return sb.toString();
    }
}
