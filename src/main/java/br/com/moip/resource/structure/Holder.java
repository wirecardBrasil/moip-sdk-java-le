package br.com.moip.resource.structure;

public class Holder {
	private String fullname;
	private String birthDate;
	private TaxDocument taxDocument = new TaxDocument();
	private Phone phone = new Phone();

	public String getFullname() {
		return fullname;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public TaxDocument getTaxDocument() {
		return taxDocument;
	}

	public Phone getPhone() {
		return phone;
	}

	public Holder setFullname(String fullname) {
		this.fullname = fullname;

		return this;
	}

	public Holder setBirthDate(String birthDate) {
		this.birthDate = birthDate;

		return this;
	}

	public Holder setTaxDocument(TaxDocument taxDocument) {
		this.taxDocument = taxDocument;

		return this;
	}

	public Holder setPhone(Phone phone) {
		this.phone = phone;

		return this;
	}
}