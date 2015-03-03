package com.moip.resource.structure;

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

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setTaxDocument(TaxDocument taxDocument) {
		this.taxDocument = taxDocument;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
}