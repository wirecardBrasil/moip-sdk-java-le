package br.com.moip.resource;

public class Mpos {

    private String pinpadId;
    private String transactionCode;

    public void setTransactionCode(String transactionCode){
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode(){
        return transactionCode;
    }

    public String getPinpadId() {
        return pinpadId;
    }

    public void setPinpadId(String pinpadId) {
        this.pinpadId = pinpadId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mpos{");
        sb.append("pinpadId='").append(pinpadId).append('\'');
        sb.append("transactionCode='").append(transactionCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
