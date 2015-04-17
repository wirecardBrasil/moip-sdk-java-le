package br.com.moip;

import br.com.moip.resource.Customer;
import br.com.moip.resource.Multiorder;
import br.com.moip.resource.Order;
import br.com.moip.resource.Refund;

public class Moip {
	public static final String PRODUCTION_ENDPOINT = "https://moip.com.br";
	public static final String SANDBOX_ENDPOINT = "https://test.moip.com.br";

	private final MoipHttp moipHttp;

	public Moip(Authentication authentication) {
		this(authentication, Moip.PRODUCTION_ENDPOINT);
	}

	public Moip(Authentication authentication, String endpoint) {
		this.moipHttp = new MoipHttp(authentication, endpoint);
	}

	public MoipHttp getMoipHttp() {
		return moipHttp;
	}

	public Customer customers() {
		Customer customer = new Customer();
		customer.setMoip(this);

		return customer;
	}

	public Order orders() {
		Order order = new Order();
		order.setMoip(this);

		return order;
	}

	public Multiorder multiorders() {
		Multiorder multiorders = new Multiorder();
		multiorders.setMoip(this);

		return multiorders;
	}

	public Refund refunds() {
		Refund refund = new Refund();
		refund.setMoip(this);

		return refund;
	}

}