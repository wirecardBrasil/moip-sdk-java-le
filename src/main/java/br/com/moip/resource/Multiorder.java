package br.com.moip.resource;

import java.util.ArrayList;
import java.util.List;

import br.com.moip.resource.structure.Amount;
import com.google.gson.Gson;
import br.com.moip.MoipHttp;

public class Multiorder extends MoipResource {
	private String id;
	private String ownId;
	private String status;
	private Amount amount;
	private List<Order> orders = new ArrayList<Order>();
	private String createdAt;
	private String updatedAt;

	public Multiorder addOrder(Order order) {
		orders.add(order);

		return this;
	}

	public Multiorder get(String id) {
		Gson gson = new Gson();

		MoipHttp moipHttp = moip.getMoipHttp();
		String json = moipHttp.sendRequest("/v2/multiorders/" + id, "GET");

		Multiorder multiorder = gson.fromJson(json, Multiorder.class);
		multiorder.setMoip(moip);

		return multiorder;
	}

	public Multiorder create() {
		Gson gson = new Gson();

		MoipHttp moipHttp = moip.getMoipHttp();
		String json = moipHttp.sendRequest("/v2/multiorders", "POST",
				gson.toJson(this));

		Multiorder multiorders = gson.fromJson(json, Multiorder.class);
		multiorders.setMoip(moip);

		return multiorders;
	}

	public String getOwnId() {
		return ownId;
	}

	public Multiorder setOwnId(String ownId) {
		this.ownId = ownId;

		return this;
	}

	public String getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public Amount getAmount() {
		return amount;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public Payment multipayments() {
		Payment payment = new Payment();
		payment.setMoip(moip);
		payment.setMultiorder(this);

		return payment;
	}
}