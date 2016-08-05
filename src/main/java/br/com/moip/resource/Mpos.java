package br.com.moip.resource;

public class Mpos {
    private String pinpadId;

    public String getPinpadId() {
        return pinpadId;
    }

    public void setPinpadId(String pinpadId) {
        this.pinpadId = pinpadId;
    }

    @Override
    public String toString() {
        return "Mpos{" +
                "pinpadId='" + pinpadId + '\'' +
                '}';
    }
}
