package br.com.moip.resource.structure;

public class FundingInstrument {
	private String id;
	private String method;
	private CreditCard creditCard;
	private Boleto boleto;
	private BankAccount onlineBankDebit;
	private BankAccount bankAccount;

	public void setCreditCard(String expirationMonth, String expirationYear,
			String number, String cvc, Holder holder) {
		setCreditCard(expirationMonth, expirationYear, number, cvc, holder,
				null);
	}

	public void setCreditCard(String expirationMonth, String expirationYear,
			String number, String cvc, Holder holder, String brand) {

		method = "CREDIT_CARD";
		creditCard = new CreditCard();
		creditCard.setBrand(brand);
		creditCard.setExpirationMonth(expirationMonth);
		creditCard.setExpirationYear(expirationYear);
		creditCard.setNumber(number);
		creditCard.setCvc(cvc);
		creditCard.setHolder(holder);
	}

	public void setBoleto(String expirationDate, String logoUri,
			String[] instructionLines) {

		method = "BOLETO";

		boleto = new Boleto();
		boleto.setExpirationDate(expirationDate);
		boleto.setLogoUri(logoUri);

		if (instructionLines != null) {
			for (int i = 0; i < instructionLines.length; ++i) {
				switch (i) {
				case 0:
					boleto.setFirstInstructionLine(instructionLines[i]);
					break;
				case 1:
					boleto.setSecondInstructionLine(instructionLines[i]);
					break;
				case 2:
					boleto.setThirdInstructionLine(instructionLines[i]);
					break;
				default:
					break;
				}
			}
		}
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