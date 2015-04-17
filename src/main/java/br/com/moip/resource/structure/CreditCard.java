package br.com.moip.resource.structure;

public class CreditCard {
	private String expirationMonth;
	private String expirationYear;
	private String number;
	private String cvc;
	private Holder holder;
	private String brand;
	private String first6;
	private String last4;

	public String getExpirationMonth() {
		return expirationMonth;
	}

	public CreditCard setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;

		return this;
	}

	public String getExpirationYear() {
		return expirationYear;
	}

	public CreditCard setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;

		return this;
	}

	public String getNumber() {
		return number;
	}

	public CreditCard setNumber(String number) {
		this.number = number;

		return this;
	}

	public String getCvc() {
		return cvc;
	}

	public CreditCard setCvc(String cvc) {
		this.cvc = cvc;

		return this;
	}

	public Holder getHolder() {
		return holder;
	}

	public CreditCard setHolder(Holder holder) {
		this.holder = holder;

		return this;
	}

	public String getBrand() {
		return brand;
	}

	public CreditCard setBrand(String brand) {
		this.brand = brand;

		return this;
	}

	public String getFirst6() {
		return first6;
	}

	public CreditCard setFirst6(String first6) {
		this.first6 = first6;

		return this;
	}

	public String getLast4() {
		return last4;
	}

	public CreditCard setLast4(String last4) {
		this.last4 = last4;

		return this;
	}
}
