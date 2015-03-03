package com.moip;

import java.util.Iterator;

import com.moip.resource.Customer;
import com.moip.resource.Multiorder;
import com.moip.resource.Order;
import com.moip.resource.Payment;
import com.moip.resource.Refund;
import com.moip.resource.structure.Address;

public class Moip {
	public static String PRODUCTION_ENDPOINT = "moip.com.br";
	public static String SANDBOX_ENDPOINT = "test.moip.com.br";

	private MoipHttp moipHttp;

	public Moip(MoipAuthentication authentication) {
		this(authentication, Moip.PRODUCTION_ENDPOINT);
	}

	public Moip(MoipAuthentication authentication, String endpoint) {
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

	public static void main(String[] args) {
		String token = "0ERVDN386WE3RZRI4YYG6QCDLMJ57LBR";
		String key = "SRZGHRXYOT0PVDLRB3YE8XQWLNLA0JRXTKOIDVDQ";
		MoipAuthentication moipBasic = new MoipBasicAuth(token, key);
		MoipAuthentication moipOAuth;

		moipOAuth = new MoipOAuth("m9mq5lni241ngslgpl910ew45bxnnez");

		Moip moip = new Moip(moipBasic, "private-31ec8-moip.apiary-mock.com");

		Customer customer = moip.customers().setOwnId("sandbox_v2_1401147277")
				.setFullname("Nome do Portador").setTaxDocument("33333333333");

		Refund refund = moip
				.orders()
				.get("ORD-VULX1EWDKXHF")
				.refund().get("REF-Q6LLDNEBXL52");

	}
}