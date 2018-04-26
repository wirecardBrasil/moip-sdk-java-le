package br.com.moip.examples;

import br.com.moip.request.MultiorderRequest;
import br.com.moip.request.OrderRequest;
import br.com.moip.request.OrderAmountRequest;
import br.com.moip.request.SubtotalsRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.ReceiverRequest;
import br.com.moip.request.AmountRequest;
import br.com.moip.resource.Multiorder;
import br.com.moip.API;
import br.com.moip.examples.setup.Setup;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MultiorderExamples {

    /**
     * The multiorder is a collection of orders.
     * It's used to allow transactions with different sellers in the same shopping cart.
     * When a multiorder is created with a single customer interaction,
     * Moip generates multiple charges and associates each of them
     * with the appropriate seller, simplifying the management of Marketplaces.
     *
     * IMPORTANT: By definition, it's not possible refund a multiorder entirely at once,
     * but you can refund order by order.
     *
     * Read more about multiorders on:
     * https://dev.moip.com.br/v2.0/docs/multipedidos
     * https://dev.moip.com.br/v2/reference#4-multipedidos
     */

    API api = new Setup().buildSetup();     // API instance

    /*
     * This method allows you to create an multiorder.
     * You can set the receivers to each order on multiorder.
     */
    public void createMultiorder() {

        Multiorder multiorder = api.multiorder().create(new MultiorderRequest()
            .ownId("meu_multiorder_id_0012.12")
            .addOrder(new OrderRequest()
                .ownId("pedido_1_id.123123123131312123")
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
                        .setNumber("66778899")
                    )
                    .shippingAddressRequest(new ShippingAddressRequest()
                        .street("Avenida Faria Lima")
                        .streetNumber("2927")
                        .zipCode("01234000")
                        .city("Sao Paulo")
                        .state("SP")
                        .complement("8")
                        .district("Itaim")
                    )
                )
                .addReceiver(new ReceiverRequest()
                    .primary("MPA-84BB10570968", new AmountRequest(), true)
                )
                .addReceiver(new ReceiverRequest()
                    .secondary("MPA-E3C8493A06AE", new AmountRequest().fixed(500), false)
                )
            )
            .addOrder(new OrderRequest()
                .ownId("pedido_2_id.123123123131312123")
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
                        .setNumber("66778899")
                    )
                    .shippingAddressRequest(new ShippingAddressRequest()
                        .street("Avenida Faria Lima")
                        .streetNumber("2927")
                        .zipCode("01234000")
                        .city("Sao Paulo")
                        .state("SP")
                        .complement("8")
                        .district("Itaim")
                    )
                )
                .addReceiver(new ReceiverRequest()
                    .primary("MPA-CULBBYHD11", new AmountRequest().percentual(25), false)
                )
                .addReceiver(new ReceiverRequest()
                    .secondary("MPA-84BB10570968", new AmountRequest(), true)
                )
            )
        );
    }

    // This method allows you to get a multiorder.
    public void getMultiorder() {

        Multiorder multiorder = api.multiorder().get("MOR-BUPA74EUD3KM");
    }
}
