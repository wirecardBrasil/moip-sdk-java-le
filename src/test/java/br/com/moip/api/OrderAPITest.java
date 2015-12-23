package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.AmountRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.OrderRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.ReceiverRequest;
import br.com.moip.request.ShippingAddressRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.Order;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class OrderAPITest {

    @Rule
    public Player player = new Player();

    private OrderAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new OrderAPI(clientFactory.client(player.getURL("").toString()));
//        api = new OrderAPI(clientFactory.client(Client.SANDBOX));
    }

    @Play("orders/create")
    @Test
    public void testCreate() {
        Order createdOrder = api.create(new OrderRequest()
                        .ownId("order_own_id")
                        .addItem("Nome do produto", 1, "Mais info...", 100)
                        .customer(new CustomerRequest()
                                        .ownId("customer_own_id")
                                        .fullname("Jose da Silva")
                                        .email("sandbox_v2_1401147277@email.com")
                        )
        );

        assertEquals("ORD-HCOWQ2QJKTAT", createdOrder.getId());
    }

    @Play("orders/create_with_receivers")
    @Test
    public void testCreateWithReceivers() {
        Order createdOrder = api.create(new OrderRequest()
                .ownId("order_own_id")
                .addItem("Nome do produto", 1, "Mais info...", 10000)
                .customer(new CustomerRequest()
                        .ownId("customer_own_id")
                        .fullname("Jose da Silva")
                        .email("sandbox_v2_1401147277@email.com")
                )
                .addReceiver(new ReceiverRequest()
                        .secondary("MPA-123123123",
                                new AmountRequest().fixed(100)))
        );

        assertEquals("ORD-77O7YGFH4H62", createdOrder.getId());
    }

    @Play("orders/create_with_customer_additional_info")
    @Test
    public void testCreateWithFullCustomer() {
        Order createdOrder = api.create(new OrderRequest()
                .ownId(UUID.randomUUID().toString())
                .addItem("Nome do produto", 1, "Mais info...", 10000)
                .customer(new CustomerRequest()
                        .ownId(UUID.randomUUID().toString())
                        .fullname("Jose da Silva")
                        .email("sandbox_v2_1401147277@email.com")
                        .birthdate(new GregorianCalendar(1989, Calendar.OCTOBER, 13).getTime())
                        .taxDocument(TaxDocumentRequest.cpf("12312312300"))
                        .phone(new PhoneRequest()
                                .setAreaCode("11")
                                .setNumber("999999999"))
                        .shippingAddressRequest(new ShippingAddressRequest()
                                                    .street("Rua dos Bobos")
                                                    .streetNumber("10")
                                                    .zipCode("11111111")
                                                    .city("Bobolandia")
                                                    .state("SP")
                                                    .complement("ao lado da rua dos chatos")
                                                    .district("Bobobairro"))
                )
        );

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        assertEquals("1989-10-13", simpleDateFormat.format(createdOrder.getCustomer().getBirthDate()));
        assertEquals("12312312300", createdOrder.getCustomer().getTaxDocument().getNumber());
        assertEquals("999999999", createdOrder.getCustomer().getPhone().getNumber());
        assertEquals("Rua dos Bobos", createdOrder.getCustomer().getShippingAddress().getStreet());
        assertEquals("10", createdOrder.getCustomer().getShippingAddress().getStreetNumber());
        assertEquals("11111111", createdOrder.getCustomer().getShippingAddress().getZipCode());
        assertEquals("Bobolandia", createdOrder.getCustomer().getShippingAddress().getCity());
        assertEquals("SP", createdOrder.getCustomer().getShippingAddress().getState());
        assertEquals("ao lado da rua dos chatos", createdOrder.getCustomer().getShippingAddress().getComplement());
        assertEquals("Bobobairro", createdOrder.getCustomer().getShippingAddress().getDistrict());

    }
}
