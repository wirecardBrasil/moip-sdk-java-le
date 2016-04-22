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
        return new StringBuilder("PaymentRequest{")
                .append("orderId='").append(orderId).append('\'')
                .append(", installmentCount=").append(installmentCount)
                .append(", fundingInstrument=").append(fundingInstrument)
                .append('}').toString();
    }
}
