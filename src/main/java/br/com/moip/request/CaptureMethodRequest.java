package br.com.moip.request;

public class CaptureMethodRequest {

    private Type type;
    private String voucher;
    private String stoneId;

    public Type getType() {
        return type;
    }

    public CaptureMethodRequest mpos() {
        this.type = Type.MPOS;

        return this;
    }

    public String getVoucher() {
        return voucher;
    }

    public CaptureMethodRequest voucher(final String voucher) {
        this.voucher = voucher;

        return this;
    }

    public String getStoneId() {
        return stoneId;
    }

    public CaptureMethodRequest stoneId(final String stoneId) {
        this.stoneId = stoneId;

        return this;
    }

    private enum Type {
        MPOS;
    }

    @Override
    public String toString() {
        return new StringBuilder("CaptureMethodRequest{").append("type=").append(type)
                .append(", voucher='").append(voucher).append('\'')
                .append(", stoneId='").append(stoneId).append('\'')
                .append('}').toString();
    }
}
