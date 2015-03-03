package com.moip.resource.structure;

public class Receiver {
	private MoipAccount moipAccount = new MoipAccount();
	private String type;
	private Amount amount = new Amount();

	public MoipAccount getMoipAccount() {
		return moipAccount;
	}

	public void setMoipAccount(MoipAccount moipAccount) {
		this.moipAccount = moipAccount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}
}