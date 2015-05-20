package br.com.moip.resource;

import br.com.moip.resource.structure.Amount;
import com.google.gson.Gson;
import br.com.moip.MoipHttp;
import br.com.moip.resource.structure.FundingInstrument;
import br.com.moip.resource.structure.BankAccount;
import br.com.moip.resource.structure.Holder;

public class Refund extends MoipResource {
	private String id;
	private String status;
	private Amount amount;
	private String type;
	private FundingInstrument refundingInstrument;
	private String method;

	private transient Order order;
	private transient Payment payment;

	public Refund execute() {
		if (order != null || payment != null) {
			Gson gson = new Gson();
			String path;

			if (order == null) {
				path = "/v2/payments/" + payment.getId() + "/refunds";
			} else {
				path = "/v2/orders/" + order.getId() + "/refunds";
			}

			MoipHttp moipHttp = moip.getMoipHttp();
			String json = moipHttp.sendRequest(path, "POST", gson.toJson(this));

			Refund refund = gson.fromJson(json, Refund.class);
			refund.setMoip(moip);

			return refund;
		}

		return this;
	}

	public Refund get(String id) {
		Gson gson = new Gson();

		MoipHttp moipHttp = moip.getMoipHttp();
		String json = moipHttp.sendRequest("/v2/refunds/" + id, "GET");

		Refund refund = gson.fromJson(json, Refund.class);
		refund.setMoip(moip);

		return refund;
	}

	public String getId() {
		return id;
	}

	public Amount getAmount() {
		return amount;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public String getMethod() {
		return method;
	}

	private Refund bankAccount(String type, String bankType, String bankNumber,
			String agencyNumber, String agencyCheckNumber,
			String accountNumber, String accountCheckNumber, Customer customer) {

		Holder holder = new Holder();
		holder.setFullname(customer.getFullname());
		holder.setTaxDocument(customer.getTaxDocument());

		this.type = type;
		this.method = "BANK_ACCOUNT";
		this.refundingInstrument = new FundingInstrument();

		BankAccount bankAccount = this.refundingInstrument.getBankAccount();
		bankAccount.setType(bankType);
		bankAccount.setBankNumber(bankNumber);
		bankAccount.setAgencyNumber(agencyNumber);
		bankAccount.setAgencyCheckNumber(agencyCheckNumber);
		bankAccount.setAccountNumber(accountNumber);
		bankAccount.setAccountCheckNumber(accountCheckNumber);
		bankAccount.setHolder(holder);

		return this;
	}

	public Refund bankAccountFull(String type, String bankNumber,
			String agencyNumber, String agencyCheckNumber,
			String accountNumber, String accountCheckNumber, Customer customer) {

		return bankAccount("FULL", type, bankNumber, agencyNumber,
				agencyCheckNumber, accountNumber, accountCheckNumber, customer);
	}

	public Refund bankAccountPartial(Integer amount, String type,
			String bankNumber, String agencyNumber, String agencyCheckNumber,
			String accountNumber, String accountCheckNumber, Customer customer) {

		this.amount = new Amount();
		this.amount.setTotal(amount);

		return bankAccount("PARTIAL", type, bankNumber, agencyNumber,
				agencyCheckNumber, accountNumber, accountCheckNumber, customer);
	}

	private Refund creditCard(String type) {
		this.method = "CREDIT_CARD";
		this.type = type;

		return this;
	}

	public Refund creditCardFull() {
		return creditCard("FULL");
	}

	public Refund creditCardPartial(Integer amount) {
		this.amount = new Amount();
		this.amount.setTotal(amount);

		return creditCard("PARTIAL");
	}

	public Refund setOrder(Order order) {
		this.order = order;

		return this;
	}

	public Refund setPayment(Payment payment) {
		this.payment = payment;

		return this;
	}
}