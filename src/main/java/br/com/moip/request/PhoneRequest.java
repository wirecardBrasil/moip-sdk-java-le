package br.com.moip.request;

public class PhoneRequest {

    private String areaCode;
    private String number;

    public PhoneRequest setAreaCode(final String areaCode) {
        this.areaCode = areaCode;

        return this;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public PhoneRequest setNumber(final String number) {
        this.number = number;

        return this;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PhoneRequest{");
        sb.append("areaCode='").append(areaCode).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
