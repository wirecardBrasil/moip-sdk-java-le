package br.com.moip.request;

public class AddressRequest {

    private String street;
    private String streetNumber;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country = "BRA";
    private String zipCode;

    public AddressRequest street(String street) {
        this.street = street;

        return this;
    }

    public AddressRequest streetNumber(String streetNumber) {
        this.streetNumber = streetNumber;

        return this;
    }

    public AddressRequest complement(String complement) {
        this.complement = complement;

        return this;
    }

    public AddressRequest district(String district) {
        this.district = district;

        return this;
    }

    public AddressRequest city(String city) {
        this.city = city;

        return this;
    }

    public AddressRequest state(String state) {
        this.state = state;

        return this;
    }

    public AddressRequest country(String country) {
        this.country = country;

        return this;
    }

    public AddressRequest zipCode(String zipCode) {
        this.zipCode = zipCode;

        return this;
    }
}
