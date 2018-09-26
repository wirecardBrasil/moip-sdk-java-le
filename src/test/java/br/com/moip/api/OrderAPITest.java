package br.com.moip.api;

import br.com.moip.request.*;
import br.com.moip.resource.FundingInstrument;
import br.com.moip.resource.Order;
import br.com.moip.resource.OrderStatus;
import br.com.moip.resource.Receiver;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
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
                .ownId("the_order.001")
                .addItem("Descrição do pedido", 1, "Mais info...", 100)
                .customer(new CustomerRequest()
                                .ownId("customer_own_id")
                                .fullname("Jose da Silva")
                                .email("sandbox_v2_1401147277@email.com")
                )
        );


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        assertEquals("ORD-ZTX7EKT9QPAY", createdOrder.getId());
        assertEquals("the_order.001", createdOrder.getOwnId());
        assertEquals(OrderStatus.CREATED, createdOrder.getStatus());
        assertEquals("V2", createdOrder.getPlatform());
        assertEquals("2018-02-22", simpleDateFormat.format(createdOrder.getCreatedAt()));
        assertEquals("2018-02-22", simpleDateFormat.format(createdOrder.getUpdatedAt()));
        assertEquals(0, createdOrder.getAmount().getPaid().intValue());
        assertEquals(11000, createdOrder.getAmount().getTotal().intValue());
        assertEquals(0, createdOrder.getAmount().getFees().intValue());
        assertEquals(0, createdOrder.getAmount().getRefunds().intValue());
        assertEquals(0, createdOrder.getAmount().getLiquid().intValue());
        assertEquals(0, createdOrder.getAmount().getOtherReceivers().intValue());
        assertEquals("BRL", createdOrder.getAmount().getCurrency());
        assertEquals(1500, createdOrder.getAmount().getSubtotals().getShipping().intValue());
        assertEquals(0, createdOrder.getAmount().getSubtotals().getAddition().intValue());
        assertEquals(0, createdOrder.getAmount().getSubtotals().getDiscount().intValue());
        assertEquals(9500, createdOrder.getAmount().getSubtotals().getItems().intValue());
        assertEquals("Descrição do pedido", createdOrder.getItems().get(0).getProduct());
        assertEquals(9500, createdOrder.getItems().get(0).getPrice().intValue());
        assertEquals(1, createdOrder.getItems().get(0).getQuantity().intValue());
        assertEquals("Camiseta estampada branca", createdOrder.getItems().get(0).getDetail());
        assertEquals("CLOTHING", createdOrder.getItems().get(0).getCategory());
        assertEquals("123", createdOrder.getAddresses().get(0).getStreetNumber());
        assertEquals("Rua de teste do SHIPPING", createdOrder.getAddresses().get(0).getStreet());
        assertEquals("Sao Paulo", createdOrder.getAddresses().get(0).getCity());
        assertEquals("8", createdOrder.getAddresses().get(0).getComplement());
        assertEquals("Bairro do SHIPPING", createdOrder.getAddresses().get(0).getDistrict());
        assertEquals("01234567", createdOrder.getAddresses().get(0).getZipCode());
        assertEquals("SP", createdOrder.getAddresses().get(0).getState());
        assertEquals("BRA", createdOrder.getAddresses().get(0).getCountry());
        assertEquals("CUS-O4C7B9LPNXN8", createdOrder.getCustomer().getId());
        assertEquals("59fb3111bc694", createdOrder.getCustomer().getOwnId());
        assertEquals("Fulano de Tal", createdOrder.getCustomer().getFullname());
        assertEquals("1988-12-30", simpleDateFormat.format(createdOrder.getCustomer().getBirthDate()));
        assertEquals("fulano@email.com", createdOrder.getCustomer().getEmail());
        assertEquals("CRC-4DVSLWYHBSPA", createdOrder.getCustomer().getFundingInstrument().getCreditCard().getId());
        assertEquals("MASTERCARD", createdOrder.getCustomer().getFundingInstrument().getCreditCard().getBrand());
        assertEquals("555566", createdOrder.getCustomer().getFundingInstrument().getCreditCard().getFirst6());
        assertEquals("8884", createdOrder.getCustomer().getFundingInstrument().getCreditCard().getLast4());
        assertTrue(createdOrder.getCustomer().getFundingInstrument().getCreditCard().getStore());
        assertEquals(FundingInstrument.Method.CREDIT_CARD, createdOrder.getCustomer().getFundingInstrument().getMethod());
        assertEquals("11", createdOrder.getCustomer().getPhone().getAreaCode());
        assertEquals("66778899", createdOrder.getCustomer().getPhone().getNumber());
        assertEquals("123", createdOrder.getCustomer().getAddresses().get(0).getStreetNumber());
        assertEquals("Rua de teste do SHIPPING", createdOrder.getCustomer().getAddresses().get(0).getStreet());
        assertEquals("Sao Paulo", createdOrder.getCustomer().getAddresses().get(0).getCity());
        assertEquals("8", createdOrder.getCustomer().getAddresses().get(0).getComplement());
        assertEquals("Bairro do SHIPPING", createdOrder.getCustomer().getAddresses().get(0).getDistrict());
        assertEquals("01234567", createdOrder.getCustomer().getAddresses().get(0).getZipCode());
        assertEquals("SP", createdOrder.getCustomer().getAddresses().get(0).getState());
        assertEquals("BRA", createdOrder.getCustomer().getAddresses().get(0).getCountry());
        assertEquals("01234567", createdOrder.getCustomer().getShippingAddress().getZipCode());
        assertEquals("Rua de teste do SHIPPING", createdOrder.getCustomer().getShippingAddress().getStreet());
        assertEquals("123", createdOrder.getCustomer().getShippingAddress().getStreetNumber());
        assertEquals("8", createdOrder.getCustomer().getShippingAddress().getComplement());
        assertEquals("Sao Paulo", createdOrder.getCustomer().getShippingAddress().getCity());
        assertEquals("Bairro do SHIPPING", createdOrder.getCustomer().getShippingAddress().getDistrict());
        assertEquals("SP", createdOrder.getCustomer().getShippingAddress().getState());
        assertEquals("BRA", createdOrder.getCustomer().getShippingAddress().getCountry());
        assertEquals("MPA-20EBD39642B3", createdOrder.getCustomer().getMoipAccountId());
        assertEquals("https://sandbox.moip.com.br/v2/customers/CUS-O4C7B9LPNXN8", createdOrder.getCustomer().getLinks().getSelfHref());
        assertEquals("https://hostedaccount-sandbox.moip.com.br?token=27241594-d5aa-406a-ba6d-776caaafc860&id=CUS-O4C7B9LPNXN8&mpa=MPA-5D5053C0B4A4", createdOrder.getCustomer().getLinks().getHostedAccountHref());
        assertEquals("CRC-4DVSLWYHBSPA", createdOrder.getCustomer().getFundingInstruments().get(0).getCreditCard().getId());
        assertEquals("MASTERCARD", createdOrder.getCustomer().getFundingInstruments().get(0).getCreditCard().getBrand());
        assertEquals("555566", createdOrder.getCustomer().getFundingInstruments().get(0).getCreditCard().getFirst6());
        assertEquals("8884", createdOrder.getCustomer().getFundingInstruments().get(0).getCreditCard().getLast4());
        assertTrue(createdOrder.getCustomer().getFundingInstruments().get(0).getCreditCard().getStore());
        assertEquals(FundingInstrument.Method.CREDIT_CARD, createdOrder.getCustomer().getFundingInstruments().get(0).getMethod());
        assertEquals("ORDER.CREATED", createdOrder.getEvents().get(0).getType());
        assertEquals("2018-02-22T15:33:38.493-03", createdOrder.getEvents().get(0).getCreatedAt());
        assertEquals("", createdOrder.getEvents().get(0).getDescription());
        assertEquals("MPA-5D5053C0B4A4", createdOrder.getReceivers().get(0).getMoipAccount().getId());
        assertEquals("matheus.nakaya@moip.com.br", createdOrder.getReceivers().get(0).getMoipAccount().getLogin());
        assertEquals("Matheus Nakaya", createdOrder.getReceivers().get(0).getMoipAccount().getFullname());
        assertEquals(Receiver.Type.PRIMARY, createdOrder.getReceivers().get(0).getType());
        assertEquals(0, createdOrder.getReceivers().get(0).getAmount().getTotal().intValue());
        assertEquals("BRL", createdOrder.getReceivers().get(0).getAmount().getCurrency());
        assertEquals(0, createdOrder.getReceivers().get(0).getAmount().getFees().intValue());
        assertEquals(0, createdOrder.getReceivers().get(0).getAmount().getRefunds().intValue());
        assertTrue(createdOrder.getReceivers().get(0).getFeePayor());
        assertEquals("https://sandbox.moip.com.br/v2/orders/ORD-ZTX7EKT9QPAY", createdOrder.getLinks().getSelf());
        assertEquals("https://checkout-new-sandbox.moip.com.br?token=9cfe4ce9-88e2-4dae-9316-da0f4733f88c&id=ORD-ZTX7EKT9QPAY", createdOrder.getLinks().payCheckout());
        assertEquals("https://checkout-new-sandbox.moip.com.br?token=9cfe4ce9-88e2-4dae-9316-da0f4733f88c&id=ORD-ZTX7EKT9QPAY&payment-method=credit-card", createdOrder.getLinks().payCreditCard());
        assertEquals("https://checkout-new-sandbox.moip.com.br?token=9cfe4ce9-88e2-4dae-9316-da0f4733f88c&id=ORD-ZTX7EKT9QPAY&payment-method=boleto", createdOrder.getLinks().payBoleto());
        assertEquals("https://checkout-sandbox.moip.com.br/debit/itau/ORD-ZTX7EKT9QPAY", createdOrder.getLinks().payOnlineBankDebitItau());
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
                        .shippingAddressRequest(new AddressRequest()
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
