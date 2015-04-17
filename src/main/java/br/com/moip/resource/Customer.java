package br.com.moip.resource;

import br.com.moip.MoipHttp;
import br.com.moip.resource.structure.Address;
import br.com.moip.resource.structure.FundingInstrument;
import br.com.moip.resource.structure.Holder;
import br.com.moip.resource.structure.Phone;
import br.com.moip.resource.structure.TaxDocument;
import com.google.gson.Gson;

public class Customer extends MoipResource {
	private String id;
	private String ownId;
	private String fullname;
	private String email;
	private Phone phone = new Phone();
	private String birthDate;
	private TaxDocument taxDocument;
	private FundingInstrument fundingInstrument;
	private Address shippingAddress;

	public Customer create() {
		Gson gson = new Gson();

		MoipHttp moipHttp = moip.getMoipHttp();
		String json = moipHttp.sendRequest("/v2/customers", "POST",
				gson.toJson(this));

		Customer customer = gson.fromJson(json, Customer.class);
		customer.setMoip(moip);

		return customer;
	}

	public Customer get(String id) {
		Gson gson = new Gson();

		MoipHttp moipHttp = moip.getMoipHttp();
		String json = moipHttp.sendRequest("/v2/customers/" + id, "GET");

		Customer customer = gson.fromJson(json, Customer.class);
		customer.setMoip(moip);

		return customer;
	}

	public Customer setCreditCard(String expirationMonth,
			String expirationYear, String number, String cvc) {

		Holder holder = new Holder();

		holder.setBirthDate(getBirthDate());
		holder.setFullname(getFullname());
		holder.setPhone(getPhone());
		holder.setTaxDocument(getTaxDocument());

		return setCreditCard(expirationMonth, expirationYear, number, cvc,
				holder);
	}

	public Customer setCreditCard(String expirationMonth,
			String expirationYear, String number, String cvc,
			Holder holder) {

		fundingInstrument = new FundingInstrument();
		fundingInstrument.setCreditCard(expirationMonth, expirationYear, number, cvc, holder);

		return this;
	}

	public String getId() {
		return id;
	}

	public String getOwnId() {
		return ownId;
	}

	public Customer setOwnId(String ownId) {
		this.ownId = ownId;

		return this;
	}

	public String getFullname() {
		return fullname;
	}

	public Customer setFullname(String fullname) {
		this.fullname = fullname;

		return this;
	}

	public String getEmail() {
		return email;
	}

	public Customer setEmail(String email) {
		this.email = email;

		return this;
	}

	public Phone getPhone() {
		return phone;
	}

	public Customer setPhone(String areaCode, String number) {
		return setPhone(areaCode, number, "55");
	}

	public Customer setPhone(String areaCode, String number, String countryCode) {
		phone = new Phone();
		phone.setAreaCode(areaCode);
		phone.setNumber(number);
		phone.setCountryCode(countryCode);

		return this;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public Customer setBirthDate(String birthDate) {
		this.birthDate = birthDate;

		return this;
	}

	public TaxDocument getTaxDocument() {
		return taxDocument;
	}

	public Customer setTaxDocument(String number) {
		return setTaxDocument(number, "CPF");
	}

	public Customer setTaxDocument(String number, String type) {
		taxDocument = new TaxDocument();
		taxDocument.setType(type);
		taxDocument.setNumber(number);

		return this;
	}

	public Customer setShippingAddress(final Address shippingAddress) {
		this.shippingAddress = shippingAddress;

		return this;
	}
}