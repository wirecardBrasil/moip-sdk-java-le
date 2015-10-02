package br.com.moip.resource.structure;

public class Address {
	private String type;
	private String street;
	private String streetNumber;
	private String complement;
	private String district;
	private String city;
	private String state;
	private String country = "BR";
	private String zipCode;

	public String getType() {
		return type;
	}

	public Address setType(String type) {
		this.type = type;

		return this;
	}

	public String getStreet() {
		return street;
	}

	public Address setStreet(String street) {
		this.street = street;

		return this;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public Address setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;

		return this;
	}

	public String getComplement() {
		return complement;
	}

	public Address setComplement(String complement) {
		this.complement = complement;

		return this;
	}

	public String getDistrict() {
		return district;
	}

	public Address setDistrict(String district) {
		this.district = district;

		return this;
	}

	public String getCity() {
		return city;
	}

	public Address setCity(String city) {
		this.city = city;

		return this;
	}

	public String getState() {
		return state;
	}

	public Address setState(String state) {
		this.state = state;

		return this;
	}

	public String getCountry() {
		return country;
	}

	public Address setCountry(String country) {
		this.country = country;

		return this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Address setZipCode(String zipCode) {
		this.zipCode = zipCode;

		return this;
	}

	@Override
	public String toString() {
		return "Address{" +
				"type='" + type + '\'' +
				", street='" + street + '\'' +
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