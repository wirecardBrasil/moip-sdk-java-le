package br.com.moip.resource.structure;

public class BankAccount {
	private String type;
	private String bankNumber;
	private String agencyNumber;
	private String agencyCheckNumber;
	private String accountNumber;
	private String accountCheckNumber;
	private Holder holder;
	private String expirationDate;
	private String returnUri;

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(String agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public String getAgencyCheckNumber() {
		return agencyCheckNumber;
	}

	public void setAgencyCheckNumber(String agencyCheckNumber) {
		this.agencyCheckNumber = agencyCheckNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountCheckNumber() {
		return accountCheckNumber;
	}

	public void setAccountCheckNumber(String accountCheckNumber) {
		this.accountCheckNumber = accountCheckNumber;
	}

	public Holder getHolder() {
		return holder;
	}

	public void setHolder(Holder holder) {
		this.holder = holder;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getReturnUri() {
		return returnUri;
	}

	public void setReturnUri(String returnUri) {
		this.returnUri = returnUri;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}