package br.com.moip.request;

public class ShippingAddressRequest {
    private String street;
    private String streetNumber;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country = "BRA";
    private String zipCode;

    public ShippingAddressRequest street(String street) {
        this.street = street;

        return this;
    }

    public ShippingAddressRequest streetNumber(String streetNumber) {
        this.streetNumber = streetNumber;

        return this;
    }

    public ShippingAddressRequest complement(String complement) {
        this.complement = complement;

        return this;
    }

    public ShippingAddressRequest district(String district) {
        this.district = district;

        return this;
    }

    public ShippingAddressRequest city(String city) {
        this.city = city;

        return this;
    }

    public ShippingAddressRequest state(String state) {
        this.state = state;

        return this;
    }

    public ShippingAddressRequest country(String country) {
        this.country = country;

        return this;
    }

    public ShippingAddressRequest zipCode(String zipCode) {
        this.zipCode = zipCode;

        return this;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "ShippingAddressRequest{" +
                "street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", complement='" + complement + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
