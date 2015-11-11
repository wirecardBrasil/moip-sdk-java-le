package br.com.moip.resource;

public class CaptureMethod {

    private Type type;
    private String voucher;
    private String stoneId;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getStoneId() {
        return stoneId;
    }

    public void setStoneId(String stoneId) {
        this.stoneId = stoneId;
    }


    private enum Type {
        MPOS;
    }

}
