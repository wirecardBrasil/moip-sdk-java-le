package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.AmountRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.MultiorderRequest;
import br.com.moip.request.OrderAmountRequest;
import br.com.moip.request.OrderRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.ReceiverRequest;
import br.com.moip.request.ShippingAddressRequest;
import br.com.moip.request.SubtotalsRequest;
import br.com.moip.request.TaxDocumentRequest;

import br.com.moip.resource.Multiorder;
import br.com.moip.resource.OrderStatus;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class MultiorderAPITest {

    @Rule
    public Player player = new Player();

    private MultiorderAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new MultiorderAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Play("multiorder/create")
    @Test
    public void testCreateMultiorder() {
        Multiorder multiorder = api.create(new MultiorderRequest()
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
                    .secondary("MPA-E3C8493A06AE", new AmountRequest().fixed(500), false))
                .addReceiver(new ReceiverRequest()
                    .primary("MPA-8D5DBB4EF8B8", new AmountRequest(), true))
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
            )
        );

        assertEquals("MOR-YRXZ81E0EK3Q", multiorder.getId());
        assertEquals("meu_multiorder_id", multiorder.getOwnId());
        assertEquals("pedido_1_id", multiorder.getOrders().get(0).getOwnId());
        assertEquals("MPA-321321321", multiorder.getOrders().get(0).getReceivers().get(0).getMoipAccount().getId());
        assertEquals("pedido_2_id", multiorder.getOrders().get(1).getOwnId());
        assertEquals((Integer)8000, multiorder.getAmount().getTotal());
        assertEquals(OrderStatus.CREATED, multiorder.getStatus());
    }

    @Play("multiorder/get")
    @Test
    public void testGetMultiorder() {
        Multiorder multiorder = api.get("MOR-F2R675R1X97P");

        assertEquals(multiorder.getId(), "MOR-F2R675R1X97P");
        assertEquals("meu_multiorder_id", multiorder.getOwnId());
        assertEquals("pedido_1_id", multiorder.getOrders().get(0).getOwnId());
        assertEquals("MPA-321321321", multiorder.getOrders().get(0).getReceivers().get(0).getMoipAccount().getId());
        assertEquals("pedido_2_id", multiorder.getOrders().get(1).getOwnId());
        assertEquals((Integer)8000, multiorder.getAmount().getTotal());
        assertEquals(OrderStatus.CREATED, multiorder.getStatus());
    }
}
