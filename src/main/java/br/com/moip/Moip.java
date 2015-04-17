package br.com.moip;

import br.com.moip.resource.Customer;
import br.com.moip.resource.Multiorder;
import br.com.moip.resource.Order;
import br.com.moip.resource.Refund;

public class Moip {
	public static final String PRODUCTION_ENDPOINT = "https://moip.com.br";
	public static final String SANDBOX_ENDPOINT = "https://test.moip.com.br";

	private MoipHttp moipHttp;

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

	public static void main(String[] args) {
		String token = "0ERVDN386WE3RZRI4YYG6QCDLMJ57LBR";
		String key = "SRZGHRXYOT0PVDLRB3YE8XQWLNLA0JRXTKOIDVDQ";
		Authentication moipBasic = new BasicAuth(token, key);
		Authentication moipOAuth;

		moipOAuth = new OAuth("m9mq5lni241ngslgpl910ew45bxnnez");

		Moip moip = new Moip(moipBasic, "private-31ec8-moip.apiary-mock.com");

		Customer customer = moip.customers().setOwnId("sandbox_v2_1401147277")
				.setFullname("Nome do Portador").setTaxDocument("33333333333");

		Refund refund = moip
				.orders()
				.get("ORD-VULX1EWDKXHF")
				.refund().get("REF-Q6LLDNEBXL52");

	}
}