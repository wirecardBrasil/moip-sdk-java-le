package br.com.moip.request;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class OrderRequestTest extends RequestTest {
	
	private static final boolean ORDERING_DATA = false;

    @Test
    public void testOrder() throws JSONException {
        OrderRequest order = new OrderRequest()
                        .ownId("order_own_id")
                        .addItem("Nome do produto", 1, "Mais info...", 100)
                        .customer(new CustomerRequest()
                                        .ownId("customer_own_id")
                                        .fullname("Jose da Silva")
                                        .email("sandbox_v2_1401147277@email.com")
                        );
        String orderJSON = new Gson().toJson(order);
        JsonObject expectedJSON = getJsonFileAsJsonObject("order/order_basic.json");
        
        JSONAssert.assertEquals(expectedJSON.toString(), orderJSON, ORDERING_DATA);

    }
    
    @Test
    public void testOrderWithReceivers() throws JSONException {
        OrderRequest order = new OrderRequest()
                .ownId("order_own_id")
                .addItem("Nome do produto", 1, "Mais info...", 10000)
                .customer(new CustomerRequest()
                        .ownId("customer_own_id")
                        .fullname("Jose da Silva")
                        .email("sandbox_v2_1401147277@email.com")
                )
                .addReceiver(new ReceiverRequest()
                        .secondary("MPA-123123123",
                                new AmountRequest().fixed(100)));
        
        String orderJSON = new Gson().toJson(order);
        JsonObject expectedJSON = getJsonFileAsJsonObject("order/order_with_receivers.json");
        
        JSONAssert.assertEquals(expectedJSON.toString(), orderJSON, ORDERING_DATA);
        
    }

    @Test
    public void testOrderWithFullCustomer() throws JSONException {
        OrderRequest order = new OrderRequest()
                .ownId("order_own_id")
                .addItem("Nome do produto", 1, "Mais info...", 10000)
                .customer(new CustomerRequest()
                        .ownId("customer_own_id")
                        .fullname("Jose da Silva")
                        .email("sandbox_v2_1401147277@email.com")
                        .birthdate(new ApiDateRequest().date(new GregorianCalendar(1989, Calendar.OCTOBER, 13).getTime()))
                        .taxDocument(TaxDocumentRequest.cpf("12312312300"))
                        .phone(new PhoneRequest()
                                .setAreaCode("11")
                                .setNumber("999999999"))
                        .shippingAddressRequest(new AddressRequest()
                                                    .street("Rua dos Bobos")
                                                    .streetNumber("10")
                                                    .zipCode("11111111")
                                                    .city("Bobolandia")
                                                    .state("SP")
                                                    .complement("ao lado da rua dos chatos")
                                                    .district("Bobobairro"))
                );
        
        String orderJSON = new Gson().toJson(order);
        JsonObject expectedJSON = getJsonFileAsJsonObject("order/order_with_full_customer.json");
        
        JSONAssert.assertEquals(expectedJSON.toString(), orderJSON, ORDERING_DATA);

    }
    
    @Test
    public void testOrderWithFullCustomerAndOrderAmount() throws JSONException {
        OrderRequest order = new OrderRequest()
                .ownId("order_own_id")
                .amount(new OrderAmountRequest()
                		.currency("BRL")
                		.subtotals(new SubtotalsRequest()
                			.shipping(8050)
            				.addition(1050)
            				.discount(2055)
                		))
                .addItem("Nome do produto", 1, "Mais info...", 10000)
                .customer(new CustomerRequest()
                        .ownId("customer_own_id")
                        .fullname("Jose da Silva")
                        .email("sandbox_v2_1401147277@email.com")
                        .birthdate(new ApiDateRequest().date(new GregorianCalendar(1989, Calendar.OCTOBER, 13).getTime()))
                        .taxDocument(TaxDocumentRequest.cpf("12312312300"))
                        .phone(new PhoneRequest()
                                .setAreaCode("11")
                                .setNumber("999999999"))
                        .shippingAddressRequest(new AddressRequest()
                                                    .street("Rua dos Bobos")
                                                    .streetNumber("10")
                                                    .zipCode("11111111")
                                                    .city("Bobolandia")
                                                    .state("SP")
                                                    .complement("ao lado da rua dos chatos")
                                                    .district("Bobobairro"))
                );
        
        String orderJSON = new Gson().toJson(order);
        JsonObject expectedJSON = getJsonFileAsJsonObject("order/order_with_full_customer_and_order_amount.json");
        
        JSONAssert.assertEquals(expectedJSON.toString(), orderJSON, ORDERING_DATA);

    }
}
