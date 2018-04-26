package br.com.moip.examples;

import br.com.moip.API;
import br.com.moip.api.filter.Filters;
import br.com.moip.api.filter.Pagination;
import br.com.moip.examples.setup.Setup;
import br.com.moip.request.OrderRequest;
import br.com.moip.request.OrderAmountRequest;
import br.com.moip.request.SubtotalsRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.ReceiverRequest;
import br.com.moip.request.AmountRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.InstallmentRequest;
import br.com.moip.request.CheckoutPreferencesRequest;
import br.com.moip.resource.Order;
import br.com.moip.response.OrderListResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExamples {

    /**
     * The Order is the representation of a product or a provided service.
     *
     * Read more about orders on:
     * https://dev.moip.com.br/v2/reference#pedidos-ec
     */

    // API instance
    API api = new Setup().buildSetup();

    /*
     * This method create an order to a created customer, using the customer's Moip ID.
     * TIP: You can add how many items you want.
     *
     * The receivers are the Moip accounts involved in the transaction.
     */
    public void createOrder() {

        Order createdOrder = api.order().create(new OrderRequest()
            .ownId("ORD-" + System.currentTimeMillis())
            .amount(new OrderAmountRequest()
                .currency("BRL")
                .subtotals(new SubtotalsRequest()
                    .shipping(1000)
                    .addition(100)
                    .discount(500)
                )
            )
            .addItem("Nome do produto 1", 1, "Mais info...", 100)
            .addItem("Nome do produto 2", 2, "Mais info...", 200)
            .addItem("Nome do produto 3", 3, "Mais info...", 300)
            .customer(new CustomerRequest()
                .id("CUS-DO69X9CD0JO0")     // Customer's Moip ID
            )
            .addReceiver(new ReceiverRequest()
                .secondary("MPA-E3C8493A06AE", new AmountRequest().percentual(85), false)
            )
        );
    }

    // Another way is create an order and customer on the same request.
    public void createOrderAndCustomer() {

        Order createdOrder = api.order().create(new OrderRequest()
            .ownId("order_own_id")
            .amount(new OrderAmountRequest()
                .currency("BRL")
                .subtotals(new SubtotalsRequest()
                    .shipping(1000)
                    .addition(100)
                    .discount(500)
                )
            )
            .addItem("Nome do produto 1", 1, "Mais info...", 100)
            .addItem("Nome do produto 2", 2, "Mais info...", 200)
            .addItem("Nome do produto 3", 3, "Mais info...", 300)
            .customer(new CustomerRequest()
                .ownId("customer_own_id")
                .fullname("Jose da Silva")
                .email("josedasilva@email.com")
                .birthdate(new ApiDateRequest().date(new Date()))
                .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                .phone(new PhoneRequest()
                    .setAreaCode("11")
                    .setNumber("55443322"))
                .shippingAddressRequest(new ShippingAddressRequest()
                    .street("Avenida Faria Lima")
                    .streetNumber("3064")
                    .complement("12 andar")
                    .city("São Paulo")
                    .state("SP")
                    .district("Itaim")
                    .country("BRA")
                    .zipCode("01452-000")
                )
            )
            .addReceiver(new ReceiverRequest()
                .secondary("MPA-E3C8493A06AE", new AmountRequest().percentual(85), false)
            )
        );
    }

    /*
     * This methods shows you how to add checkout preferences to the order at your creation.
     * TIP: read more about checkout preferences on https://dev.moip.com.br/v2.0/reference#criar-pedido-checkout-moip.
     */
    public void createOrderWithCheckoutPreferences() {

        List<InstallmentRequest> installmentRequestList = new ArrayList<InstallmentRequest>();

        installmentRequestList.add(new InstallmentRequest()
            .quantity(new int[]{1, 2})
            .addition(1000));

        Order createdOrder = api.order().create(new OrderRequest()
            .ownId("meu_id_order")
            .amount(new OrderAmountRequest()
                .currency("BRL")
                .subtotals(new SubtotalsRequest()
                    .shipping(1000)
                    .addition(100)
                    .discount(500)
                )
            )
            .addItem("Descrição do pedido", 1, "Camiseta estampada branca", 9500)
            .customer(new CustomerRequest().id("CUS-DO69X9CD0JO0"))     // Customer's Moip ID
            .checkoutPreferences(new CheckoutPreferencesRequest()
                .setRedirectUrls(new CheckoutPreferencesRequest
                    .RedirectUrlsRequest("http://www.lojaexemplo.com.br/compraFeita", "http://www.lojaexemplo.com.br/error"))
                .installments(installmentRequestList)
            )
            .addReceiver(new ReceiverRequest()
                .secondary("MPA-E3C8493A06AE", new AmountRequest().percentual(85), false)
            )

        );
    }

    // This method allows you to gets an order by your Moip ID.
    public void getOrder() {

        Order order = api.order().get("ORD-CD6IC1H4P599");
    }

    // This method allows you to list all the created orders.
    public void listOrder() {

        OrderListResponse orders = api.order().list();
    }

    // You can use some filters to perform your search.
    public void listOrderWithSearchParams() {

        Filters filters = new Filters()
            .between("amount", "1000", "10000");
        OrderListResponse orders = api.order().list(new Pagination(10,0), filters, "josé silva");
    }
}
