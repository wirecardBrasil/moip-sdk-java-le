package br.com.moip.resource;

public class Phone {
    private String areaCode;
    private String number;

    public Phone setAreaCode(final String areaCode) {
        this.areaCode = areaCode;

        return this;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public Phone setNumber(final String number) {
        this.number = number;

        return this;
    }

    public String getNumber() {
        return number;
    }
}
