package br.com.moip.request;

public class MposRequest {
    private String pinpadId;
    private String transactionCode;

    public MposRequest transactionCode(String transactionCode){
        this.transactionCode = transactionCode;
        return this;
    }

    public String getTransactionCode(){
        return transactionCode;
    }

    public MposRequest PinpadId(String pinpadId){
        this.pinpadId = pinpadId;
        return this;
    }

    public String getPinpadId() {
        return pinpadId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MposRequest{");
        sb.append("pinpadId='").append(pinpadId).append('\'');
        sb.append("transactionCode='").append(transactionCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
