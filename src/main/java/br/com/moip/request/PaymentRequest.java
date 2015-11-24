package br.com.moip.request;

public class PaymentRequest {

    private String orderId;
    private int installmentCount;
    private FundingInstrumentRequest fundingInstrument = new FundingInstrumentRequest();

    public String getOrderId() {
        return orderId;
    }

    public PaymentRequest orderId(final String orderId) {
        this.orderId = orderId;

        return this;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public PaymentRequest installmentCount(final int installmentCount) {
        this.installmentCount = installmentCount;

        return this;
    }

    public FundingInstrumentRequest getFundingInstrument() {
        return fundingInstrument;
    }

    public PaymentRequest fundingInstrument(final FundingInstrumentRequest fundingInstrument) {
        this.fundingInstrument = fundingInstrument;

        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentRequest{");
        sb.append("orderId='").append(orderId).append('\'');
        sb.append(", installmentCount=").append(installmentCount);
        sb.append(", fundingInstrument=").append(fundingInstrument);
        sb.append('}');
        return sb.toString();
    }
}
