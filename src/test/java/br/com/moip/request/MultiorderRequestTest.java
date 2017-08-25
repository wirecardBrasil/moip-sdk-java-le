package br.com.moip.request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MultiorderRequestTest extends RequestTest{

    @Test
    public void testMultiorderRequest() throws JSONException {
        MultiorderRequest multiorder = new MultiorderRequest()
            .ownId("meu_multiorder_id")
            .addOrder(new OrderRequest()
                .ownId("pedido_1_id")
                .amount(new OrderAmountRequest()
                    .subtotals(new SubtotalsRequest().shipping(2000))
                    .currency("BRL")
                )
                .addItem("Camisa Verde e Amarelo - Brasil", 1, "Seleção Brasileira", 2000)
                .customer(new CustomerRequest()
                    .ownId("customer[1234]")
                    .fullname("Joao Sousa")
                    .email("joao.sousa@email.com")
                    .birthdate(new ApiDateRequest().date(new GregorianCalendar(1988, Calendar.DECEMBER, 30).getTime()))
                    .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    .phone(new PhoneRequest()
                        .countryCode("55")
                        .setAreaCode("11")
                        .setNumber("66778899"))
                    .shippingAddressRequest(new ShippingAddressRequest()
                        .street("Avenida Faria Lima")
                        .streetNumber("2927")
                        .zipCode("01234000")
                        .city("Sao Paulo")
                        .state("SP")
                        .complement("8")
                        .district("Itaim"))
                )
                .addReceiver(new ReceiverRequest()
                    .secondary("MPA-123123123", new AmountRequest().fixed(500), false))
                .addReceiver(new ReceiverRequest()
                    .primary("MPA-321321321", new AmountRequest(), true))
            )
            .addOrder(new OrderRequest()
                .ownId("pedido_2_id")
                .amount(new OrderAmountRequest()
                    .subtotals(new SubtotalsRequest().shipping(3000))
                    .currency("BRL")
                )
                .addItem("Camisa Preta - Alemanha", 1, "Camiseta da Copa 2014", 1000)
                .customer(new CustomerRequest()
                    .ownId("customer[1234]")
                    .fullname("Joao Sousa")
                    .email("joao.sousa@email.com")
                    .birthdate(new ApiDateRequest().date(new GregorianCalendar(1988, Calendar.DECEMBER, 30).getTime()))
                    .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    .phone(new PhoneRequest()
                        .countryCode("55")
                        .setAreaCode("11")
                        .setNumber("66778899"))
                    .shippingAddressRequest(new ShippingAddressRequest()
                        .street("Avenida Faria Lima")
                        .streetNumber("2927")
                        .zipCode("01234000")
                        .city("Sao Paulo")
                        .state("SP")
                        .complement("8")
                        .district("Itaim"))
                )
                .addReceiver(new ReceiverRequest()
                    .primary("MPA-123123123", new AmountRequest())
                )
            );

        String multiorderJSON = new Gson().toJson(multiorder);
        JsonObject expectedJSON = getJsonFileAsJsonObject("multiorder/multiorder_basic.json");
        JSONAssert.assertEquals(expectedJSON.toString(), multiorderJSON, false);

    }
}
