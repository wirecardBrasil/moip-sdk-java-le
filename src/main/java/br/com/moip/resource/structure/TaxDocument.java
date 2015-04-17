package br.com.moip.resource.structure;

public class TaxDocument {
	private String type;
	private String number;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public static TaxDocument cpf(final String number) {
		TaxDocument taxDocument = new TaxDocument();

		taxDocument.setType("CPF");
		taxDocument.setNumber(number);

		return taxDocument;
	}
}