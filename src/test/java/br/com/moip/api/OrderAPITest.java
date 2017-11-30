package br.com.moip.api;

import br.com.moip.request.AmountRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.OrderRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.ReceiverRequest;
import br.com.moip.request.ShippingAddressRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.CheckoutPreferencesRequest;
import br.com.moip.request.InstallmentRequest;
import br.com.moip.resource.Order;
import br.com.moip.resource.OrderStatus;
import br.com.moip.response.OrderListResponse;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class OrderAPITest {

    @Rule
    public Player player = new Player();

    private OrderAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new OrderAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Play("orders/get")
    @Test
    public void testGet() {
        Order order = api.get("ORD-HCOWQ2QJKTAT");

        assertEquals("ORD-HCOWQ2QJKTAT", order.getId());
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Play("orders/create")
    @Test
    public void testCreate() {
        Order createdOrder = api.create(new OrderRequest()
                .ownId("meu_id_order")
                .addItem("Descrição do pedido", 1, "Mais info...", 100)
                .customer(new CustomerRequest()
                                .ownId("customer_own_id")
                                .fullname("Jose da Silva")
                                .email("sandbox_v2_1401147277@email.com")
                )
        );

        assertEquals("https://sandbox.moip.com.br/v2/orders/ORD-XVLUNGP6ORXH", createdOrder.getLinks().getSelf());
        assertEquals("https://checkout-new-sandbox.moip.com.br?token=900cdb9f-32f0-4ce2-81eb-f8748631b24b&id=ORD-XVLUNGP6ORXH", createdOrder.getLinks().getCheckout().getPayCheckoutHref());
        assertEquals("https://checkout-new-sandbox.moip.com.br?token=900cdb9f-32f0-4ce2-81eb-f8748631b24b&id=ORD-XVLUNGP6ORXH&payment-method=boleto", createdOrder.getLinks().getCheckout().getPayBoletoLink());
        assertEquals("https://checkout-new-sandbox.moip.com.br?token=900cdb9f-32f0-4ce2-81eb-f8748631b24b&id=ORD-XVLUNGP6ORXH&payment-method=credit-card", createdOrder.getLinks().getCheckout().getPayCreditCardHref());
        assertEquals("https://checkout-sandbox.moip.com.br/debit/itau/ORD-XVLUNGP6ORXH", createdOrder.getLinks().getCheckout().getPayOnlineBankDebitItauHref());
        assertEquals("https://checkout-new-sandbox.moip.com.br?token=900cdb9f-32f0-4ce2-81eb-f8748631b24b&id=ORD-XVLUNGP6ORXH", createdOrder.getLinks().payCheckout());
        assertEquals("https://checkout-new-sandbox.moip.com.br?token=900cdb9f-32f0-4ce2-81eb-f8748631b24b&id=ORD-XVLUNGP6ORXH&payment-method=boleto", createdOrder.getLinks().payBoleto());
        assertEquals("https://checkout-new-sandbox.moip.com.br?token=900cdb9f-32f0-4ce2-81eb-f8748631b24b&id=ORD-XVLUNGP6ORXH&payment-method=credit-card", createdOrder.getLinks().payCreditCard());
        assertEquals("https://checkout-sandbox.moip.com.br/debit/itau/ORD-XVLUNGP6ORXH", createdOrder.getLinks().payOnlineBankDebitItau());
        assertEquals("ORD-XVLUNGP6ORXH", createdOrder.getId());
    }

    @Play("orders/create_with_receivers")
    @Test
    public void testCreateWithReceivers() {
        Order createdOrder = api.create(new OrderRequest()
                .ownId("meu_id_order")
                .addItem("Camiseta estampada branca", 1, "Descrição do pedido", 11000)
                .customer(new CustomerRequest()
                        .ownId("identificador_cliente123")
                        .fullname("Rafael Pereira")
                        .email("afael@email.com")
                )
                .addReceiver(new ReceiverRequest()
                        .secondary("MPA-321321321321",
                                new AmountRequest().fixed(2000)))
        );

        assertEquals("ORD-PQ8KF1W1PQ4F", createdOrder.getId());

        assertEquals(2, createdOrder.getReceivers().size());

        assertEquals(9000, createdOrder.getReceivers().get(0).getAmount().getTotal().intValue());
        assertEquals("MPA-123123123123", createdOrder.getReceivers().get(0).getMoipAccount().getId());
        assertEquals("Teste Moip", createdOrder.getReceivers().get(0).getMoipAccount().getFullname());
        assertEquals("teste@moip.com.br", createdOrder.getReceivers().get(0).getMoipAccount().getLogin());
        assertTrue(createdOrder.getReceivers().get(0).isPrimary());
        assertTrue(createdOrder.getReceivers().get(0).getFeePayor());

        assertEquals(2000, createdOrder.getReceivers().get(1).getAmount().getTotal().intValue());
        assertEquals("MPA-321321321321", createdOrder.getReceivers().get(1).getMoipAccount().getId());
        assertEquals("Segundo Teste Moip", createdOrder.getReceivers().get(1).getMoipAccount().getFullname());
        assertEquals("teste2@moip.com.br", createdOrder.getReceivers().get(1).getMoipAccount().getLogin());
        assertTrue(createdOrder.getReceivers().get(1).isSecondary());
        assertFalse(createdOrder.getReceivers().get(1).getFeePayor());
    }

    @Play("orders/create_with_checkout_preferences")
    @Test
    public void testCreateWithCheckoutPreferences() {
        int[] quantity = {1,6};
        Order createdOrder = api.create(new OrderRequest()
                .ownId("order_own_id")
                .addItem("Nome do produto", 1, "Mais info...", 10000)
                .customer(new CustomerRequest()
                        .ownId("customer_own_id")
                        .fullname("Jose da Silva")
                        .email("sandbox_v2_1401147277@email.com")
                )
                .checkoutPreferences(new CheckoutPreferencesRequest()
                        .addInstallment(new InstallmentRequest()
                            .quantity(quantity)
                            .addition(100)
                            .discount(0)
                        )
                        .setRedirectUrls(new CheckoutPreferencesRequest.RedirectUrlsRequest(
                                "https://dev.moip.com.br",
                                "https://dev.moip.com.br/docs"
                            )
                        )
                )
        );

        assertArrayEquals(quantity, createdOrder.getCheckoutPreferences().getInstallments().get(0).getQuantity());
        assertEquals(100, createdOrder.getCheckoutPreferences().getInstallments().get(0).getAddition());
        assertEquals(0, createdOrder.getCheckoutPreferences().getInstallments().get(0).getDiscount());
        assertEquals("https://dev.moip.com.br/docs", createdOrder.getCheckoutPreferences().getRedirectUrls().getUrlFailure());
        assertEquals("https://dev.moip.com.br", createdOrder.getCheckoutPreferences().getRedirectUrls().getUrlSuccess());
    }

    @Play("orders/create_with_customer_additional_info")
    @Test
    public void testCreateWithFullCustomer() {
        Order createdOrder = api.create(new OrderRequest()
                .ownId(UUID.randomUUID().toString())
                .addItem("Câmera fotográfica", 1, "Câmera fotográfica, modelo CM54296, cor preta", 100000)
                .customer(new CustomerRequest()
                        .ownId("identificador_cliente")
                        .fullname("Rafael Pereira")
                        .email("rafael@email.com")
                        .birthdate(new ApiDateRequest().date(new GregorianCalendar(1969, Calendar.DECEMBER, 31).getTime()))
                        .taxDocument(TaxDocumentRequest.cpf("12312312300"))
                        .phone(new PhoneRequest()
                                .setAreaCode("11")
                                .setNumber("55443322"))
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

        assertEquals("1969-12-31", simpleDateFormat.format(createdOrder.getCustomer().getBirthDate()));
        assertEquals("22222222222", createdOrder.getCustomer().getTaxDocument().getNumber());
        assertEquals("55443322", createdOrder.getCustomer().getPhone().getNumber());
        assertEquals("Rua dos Bobos", createdOrder.getCustomer().getShippingAddress().getStreet());
        assertEquals("10", createdOrder.getCustomer().getShippingAddress().getStreetNumber());
        assertEquals("11111111", createdOrder.getCustomer().getShippingAddress().getZipCode());
        assertEquals("Bobolandia", createdOrder.getCustomer().getShippingAddress().getCity());
        assertEquals("SP", createdOrder.getCustomer().getShippingAddress().getState());
        assertEquals("ao lado da rua dos chatos", createdOrder.getCustomer().getShippingAddress().getComplement());
        assertEquals("Bobobairro", createdOrder.getCustomer().getShippingAddress().getDistrict());
        assertEquals("BRA", createdOrder.getCustomer().getShippingAddress().getCountry());

    }

    @Play("orders/list")
    @Test
    public void testGetOrderList() {
        OrderListResponse orderListResponse = api.list();
        assertEquals(20, orderListResponse.getOrders().size());
        assertEquals("ORD-UQUCZIB66I4U", orderListResponse.getOrders().get(0).getId());
        assertEquals("ORD-OBC77GS8R20D", orderListResponse.getOrders().get(1).getId());
        assertEquals("jose silva", orderListResponse.getOrders().get(0).getCustomer().getFullname());
    }

}
