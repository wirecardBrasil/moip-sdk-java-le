package br.com.moip.resource.structure;

public class FundingInstrument {
	private String id;
	private String method;
	private CreditCard creditCard;
	private Boleto boleto;
	private BankAccount onlineBankDebit;
	private BankAccount bankAccount;

	public void setCreditCard(final CreditCard creditCard) {
		method = "CREDIT_CARD";

		this.creditCard = creditCard;
	}

	public void setBoleto(final Boleto boleto) {
		method = "BOLETO";

		this.boleto = boleto;
	}

	public void setOnlineBankDebit(String bankNumber, String expirationDate,
			String returnUri) {
		method = "ONLINE_BANK_DEBIT";

		onlineBankDebit = new BankAccount();
		onlineBankDebit.setBankNumber(bankNumber);
		onlineBankDebit.setExpirationDate(expirationDate);
		onlineBankDebit.setReturnUri(returnUri);
	}

	public String getId() {
		return id;
	}

	public String getMethod() {
		return method;
	}

	public BankAccount getBankAccount() {
		if (bankAccount == null) {
			bankAccount = new BankAccount();
		}

		return onlineBankDebit;
	}

	public CreditCard getCreditCard() {
		if (creditCard == null) {
			creditCard = new CreditCard();
		}

		return creditCard;
	}

	public Boleto getBoleto() {
		if (boleto == null) {
			boleto = new Boleto();
		}

		return boleto;
	}
}