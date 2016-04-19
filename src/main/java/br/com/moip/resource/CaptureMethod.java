package br.com.moip.resource;

public class CaptureMethod {

    private Type type;
    private String voucher;
    private String stoneId;

    public Type getType() {
        return type;
    }

    public String getVoucher() {
        return voucher;
    }

    public String getStoneId() {
        return stoneId;
    }

    private enum Type {
        MPOS;
    }

    @Override
    public String toString() {
        return new StringBuilder("CaptureMethod{")
                .append("type=").append(type)
                .append(", voucher='").append(voucher).append('\'')
                .append(", stoneId='").append(stoneId).append('\'')
                .append('}').toString();
    }
}
