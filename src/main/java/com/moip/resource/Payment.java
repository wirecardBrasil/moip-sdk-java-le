package com.moip.resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.moip.MoipHttp;
import com.moip.resource.structure.Amount;
import com.moip.resource.structure.Event;
import com.moip.resource.structure.Fee;
import com.moip.resource.structure.FundingInstrument;
import com.moip.resource.structure.Holder;

public class Payment extends MoipResource {
	private String id;
	private String status;
	private Amount amount;
	private Integer installmentCount = 1;
	private FundingInstrument fundingInstrument;
	private List<Fee> fees;
	private List<Event> events;
	private String updatedAt;
	private String createdAt;

	private transient Order order;
	private transient Multiorder multiorder;

	public Payment get(String id) {
		if (order != null || multiorder != null) {
			Gson gson = new Gson();
			String path;

			if (multiorder == null) {
				path = "/v2/payments/" + id;
			} else {
				path = "/v2/multipayments/" + id;
			}

			MoipHttp moipHttp = moip.getMoipHttp();
			String json = moipHttp.sendRequest(path, "GET");

			Payment payment = gson.fromJson(json, Payment.class);
			payment.setMoip(moip);

			return payment;
		}

		return this;
	}

	public Payment execute() {
		Gson gson = new Gson();
		String path;

		if (multiorder == null) {
			path = "/v2/orders/" + order.getId() + "/payments";
		} else {
			path = "/v2/multiorders/" + multiorder.getId() + "/multipayments";
		}

		MoipHttp moipHttp = moip.getMoipHttp();
		String json = moipHttp.sendRequest(path, "POST", gson.toJson(this));

		Payment payment = gson.fromJson(json, Payment.class);
		payment.setMoip(moip);

		return payment;
	}

	public Amount getAmount() {
		return amount;
	}

	public Payment setAmount(Amount amount) {
		this.amount = amount;

		return this;
	}

	public Integer getInstallmentCount() {
		return installmentCount;
	}

	public Payment setInstallmentCount(Integer installmentCount) {
		this.installmentCount = installmentCount;

		return this;
	}

	public Payment setCreditCard(String expirationMonth, String expirationYear,
			String number, String cvc, Customer customer) {

		Holder holder = new Holder();
		holder.setFullname(customer.getFullname());
		holder.setBirthDate(customer.getBirthDate());
		holder.setTaxDocument(customer.getTaxDocument());
		holder.setPhone(customer.getPhone());

		fundingInstrument = new FundingInstrument();
		fundingInstrument.setCreditCard(expirationMonth, expirationYear,
				number, cvc, holder);

		return this;
	}

	public Payment setBoleto(String expirationDate, String logoUri,
			String[] instructionLines) {

		fundingInstrument = new FundingInstrument();
		fundingInstrument.setBoleto(expirationDate, logoUri, instructionLines);

		return this;
	}

	public Payment setOnlineBankDebit(String bankNumber, String expirationDate,
			String returnUri) {

		fundingInstrument = new FundingInstrument();
		fundingInstrument.setOnlineBankDebit(bankNumber, expirationDate,
				returnUri);

		return this;
	}

	public String getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public Iterator<Event> getEventIterator() {
		if (events == null) {
			events = new ArrayList<Event>();
		}

		return events.iterator();
	}

	public Iterator<Fee> getFeeIterator() {
		if (fees == null) {
			fees = new ArrayList<Fee>();
		}

		return fees.iterator();
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Payment setOrder(Order order) {
		this.order = order;

		return this;
	}

	public Payment setMultiorder(Multiorder multiorder) {
		this.multiorder = multiorder;

		return this;
	}

	public Refund refund() {
		Refund refund = new Refund();
		refund.setMoip(moip);
		refund.setPayment(this);

		return refund;
	}
}
