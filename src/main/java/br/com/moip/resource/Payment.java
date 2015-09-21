package br.com.moip.resource;

import br.com.moip.MoipException;
import br.com.moip.MoipHttp;
import br.com.moip.ValidationException;
import br.com.moip.resource.links.Links;
import br.com.moip.resource.structure.Amount;
import br.com.moip.resource.structure.Boleto;
import br.com.moip.resource.structure.CreditCard;
import br.com.moip.resource.structure.Errors;
import br.com.moip.resource.structure.Event;
import br.com.moip.resource.structure.Fee;
import br.com.moip.resource.structure.FundingInstrument;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	private Links _links;
	private String ERROR;
	private List<Errors> errors;

	private transient Order order;
	private transient Multiorder multiorder;

	public void setId(String id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FundingInstrument getFundingInstrument() {
		return fundingInstrument;
	}

	public void setFundingInstrument(FundingInstrument fundingInstrument) {
		this.fundingInstrument = fundingInstrument;
	}

	public List<Fee> getFees() {
		return fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Order getOrder() {
		return order;
	}

	public Multiorder getMultiorder() {
		return multiorder;
	}

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

		if (payment.hasUnexpectedError()) {
			throw new MoipException();
		}

		if (payment.hasValidationError()){
			throw new ValidationException(payment.getErrors());
		}

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

	public Payment setCreditCard(final CreditCard creditCard) {
		fundingInstrument = new FundingInstrument();
		fundingInstrument.setCreditCard(creditCard);

		return this;
	}

	public Payment setBoleto(final Boleto boleto) {
		fundingInstrument = new FundingInstrument();
		fundingInstrument.setBoleto(boleto);

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

	public Links get_links() {
		return _links;
	}

	public void set_links(Links _links) {
		this._links = _links;
	}

	public boolean hasValidationError() {
		return this.getErrors() != null && !this.getErrors().isEmpty();
	}

	public boolean hasUnexpectedError(){
		return getERROR() != null;
	}


	public String getERROR() {
		return ERROR;
	}

	public void setERROR(String ERROR) {
		this.ERROR = ERROR;
	}

	public List<Errors> getErrors() {
		return errors;
	}

	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}
}
