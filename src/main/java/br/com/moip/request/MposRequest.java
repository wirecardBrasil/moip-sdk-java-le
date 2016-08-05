package br.com.moip.request;

public class MposRequest {
    private String pinpadId;

    public MposRequest PinpadId(String pinpadId){
        this.pinpadId = pinpadId;
        return this;
    }

    public String getPinpadId() {
        return pinpadId;
    }
}
