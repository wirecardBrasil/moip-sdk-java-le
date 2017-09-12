package br.com.moip.request;

public class RefundRequest {
    private String resourceId;
    private Integer amount;
    private RefundingInstrumentRequest refundingInstrument;

    public RefundRequest(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getId() {
        return resourceId;
    }

    public RefundRequest amount(Integer amount) {
        this.amount = amount;

        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public RefundRequest refundingInstrument(RefundingInstrumentRequest refundingInstrument) {
        this.refundingInstrument = refundingInstrument;

        return this;
    }

    public RefundingInstrumentRequest getRefundingInstrument() {
        return refundingInstrument;
    }

    @Override
    public String toString() {
        return new StringBuilder("RefundRequest{")
            .append("resourceId='").append(resourceId).append('\'')
            .append(", amount=").append(amount)
            .append(", refundingInstrument=").append(refundingInstrument)
            .append("}").toString();
    }
}

