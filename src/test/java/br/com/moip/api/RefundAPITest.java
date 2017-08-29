package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.BankAccountRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.RefundRequest;
import br.com.moip.request.RefundingInstrumentRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.Refund;
import br.com.moip.resource.RefundingInstrument;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RefundAPITest {

    private final ClientFactory clientFactory = new ClientFactory();

    private RefundAPI api;

    @Rule
    public Player player = new Player();

    @Before
    public void setUp() {
        Client client = clientFactory.client(player.getURL("").toString());
        api = new RefundAPI(client);
    }

    @Play("refunds/order_cc_partial")
    @Test
    public void testRefundOrderCreditCardPartial() {
        Refund refund = api.order(
            new RefundRequest("ORD-89SOQ6FMPJPX")
                .refundingInstrument(new RefundingInstrumentRequest().creditCard())
                .amount(2000)
        );

        assertEquals("REF-8H7W98FM52NF", refund.getId());
        assertEquals(Refund.Status.COMPLETED, refund.getStatus());
        assertEquals(Refund.Type.PARTIAL, refund.getType());
        assertNotNull(refund.getEvents());
        assertEquals((Integer)2000, refund.getAmount().getTotal());
        assertEquals(RefundingInstrument.Method.CREDIT_CARD, refund.getRefundingInstrument().getMethod());
        assertEquals("https://sandbox.moip.com.br/v2/payments/PAY-J253A3V7ATLY", refund.getLinks().paymentLink());

    }

    @Play("refunds/order_cc_full")
    @Test
    public void testRefundOrderCreditCardFull() {
        Refund refund = api.order(
            new RefundRequest("ORD-RCLBT1UZZUEL")
                .refundingInstrument(new RefundingInstrumentRequest().creditCard())
        );

        assertEquals("REF-PDDK57SS5DUC", refund.getId());
        assertEquals(Refund.Status.COMPLETED, refund.getStatus());
        assertEquals(Refund.Type.FULL, refund.getType());
        assertNotNull(refund.getEvents());
        assertEquals((Integer)102470, refund.getAmount().getTotal());
        assertEquals(RefundingInstrument.Method.CREDIT_CARD, refund.getRefundingInstrument().getMethod());
        assertEquals("https://sandbox.moip.com.br/v2/payments/PAY-7VGBQ9TF4T5A", refund.getLinks().paymentLink());
    }

    @Play("refunds/order_boleto_full")
    @Test
    public void testRefundOrderBankAccountFull() {
        Refund refund = api.order(
            new RefundRequest("ORD-GS1LSQ3SO9SY")
                .refundingInstrument(new RefundingInstrumentRequest()
                    .bankAccount(
                        new BankAccountRequest()
                            .checking()
                            .bankNumber("001")
                            .accountNumber("1234")
                            .accountCheckNumber("1")
                            .agencyNumber("4444444")
                            .agencyCheckNumber("2")
                            .holder(new HolderRequest()
                                .fullname("Nome do Portador")
                                .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                            )
                    )
                )
        );

        assertEquals("REF-L6K1IKMWVO87", refund.getId());
        assertEquals(Refund.Status.REQUESTED, refund.getStatus());
        assertEquals(Refund.Type.FULL, refund.getType());
        assertNotNull(refund.getEvents());
        assertEquals((Integer)102470, refund.getAmount().getTotal());
        assertEquals(RefundingInstrument.Method.BANK_ACCOUNT, refund.getRefundingInstrument().getMethod());
        assertEquals("https://sandbox.moip.com.br/v2/payments/PAY-NLC093SDXR8X", refund.getLinks().paymentLink());
    }

    @Play("refunds/order_boleto_partial")
    @Test
    public void testRefundOrderBankAccountPartial() {
        Refund refund = api.order(
            new RefundRequest("ORD-PW650FBY3GLU")
                .refundingInstrument(new RefundingInstrumentRequest()
                    .bankAccount(
                        new BankAccountRequest()
                            .checking()
                            .bankNumber("001")
                            .accountNumber("1234")
                            .accountCheckNumber("1")
                            .agencyNumber("4444444")
                            .agencyCheckNumber("2")
                            .holder(new HolderRequest()
                                .fullname("Nome do Portador")
                                .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                            )
                    )
                )
                .amount(2000)
        );

        assertEquals("REF-PW9CU6JMQ9TL", refund.getId());
        assertEquals(Refund.Status.REQUESTED, refund.getStatus());
        assertEquals(Refund.Type.PARTIAL, refund.getType());
        assertNotNull(refund.getEvents());
        assertEquals((Integer)10000, refund.getAmount().getTotal());
        assertEquals(RefundingInstrument.Method.BANK_ACCOUNT, refund.getRefundingInstrument().getMethod());
        assertEquals("https://sandbox.moip.com.br/v2/payments/PAY-1RS1LQV2QH47", refund.getLinks().paymentLink());
    }

    @Play("refunds/payment_cc_partial")
    @Test
    public void testRefundPaymentCreditCardPartial() {
        Refund refund = api.payment(
            new RefundRequest("PAY-70980H9B6L5R")
                .refundingInstrument(new RefundingInstrumentRequest().creditCard())
                .amount(2000)
        );

        assertEquals("REF-IPR4MQ4NVSFZ", refund.getId());
        assertEquals(Refund.Status.COMPLETED, refund.getStatus());
        assertEquals(Refund.Type.PARTIAL, refund.getType());
        assertNotNull(refund.getEvents());
        assertEquals((Integer)100000, refund.getAmount().getTotal());
        assertEquals(RefundingInstrument.Method.CREDIT_CARD, refund.getRefundingInstrument().getMethod());
        assertEquals("https://sandbox.moip.com.br/v2/orders/ORD-5L41ID7GSN09", refund.getLinks().orderLink());

    }

    @Play("refunds/payment_cc_full")
    @Test
    public void testRefundPaymentCreditCardFull() {
        Refund refund = api.payment(
            new RefundRequest("PAY-UMZU87SEFAYW")
                .refundingInstrument(new RefundingInstrumentRequest().creditCard())
        );

        assertEquals("REF-T7TBI1JS7TQ3", refund.getId());
        assertEquals(Refund.Status.COMPLETED, refund.getStatus());
        assertEquals(Refund.Type.FULL, refund.getType());
        assertNotNull(refund.getEvents());
        assertEquals((Integer)102470, refund.getAmount().getTotal());
        assertEquals(RefundingInstrument.Method.CREDIT_CARD, refund.getRefundingInstrument().getMethod());
        assertEquals("https://sandbox.moip.com.br/v2/orders/ORD-PL66SYQ9TWWT", refund.getLinks().orderLink());
    }

    @Play("refunds/payment_boleto_full")
    @Test
    public void testRefundPaymentBankAccountFull() {
        Refund refund = api.payment(
            new RefundRequest("PAY-K6GFREQDHVV8")
                .refundingInstrument(new RefundingInstrumentRequest()
                    .bankAccount(
                        new BankAccountRequest()
                            .checking()
                            .bankNumber("001")
                            .accountNumber("1234")
                            .accountCheckNumber("1")
                            .agencyNumber("4444444")
                            .agencyCheckNumber("2")
                            .holder(new HolderRequest()
                                    .fullname("Nome do Portador")
                                    .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                            )
                    )
                )
        );

        assertEquals("REF-4D5LXJ5EBUOB", refund.getId());
        assertEquals(Refund.Status.REQUESTED, refund.getStatus());
        assertEquals(Refund.Type.FULL, refund.getType());
        assertNotNull(refund.getEvents());
        assertEquals((Integer)102470, refund.getAmount().getTotal());
        assertEquals(RefundingInstrument.Method.BANK_ACCOUNT, refund.getRefundingInstrument().getMethod());
        assertEquals("https://sandbox.moip.com.br/v2/orders/ORD-9PWJ1P1TZN4B", refund.getLinks().orderLink());
    }

    @Play("refunds/payment_boleto_partial")
    @Test
    public void testRefundPaymentBankAccountPartial() {
        Refund refund = api.payment(
            new RefundRequest("PAY-E4Q0N9TK0BFW")
                .refundingInstrument(new RefundingInstrumentRequest()
                    .bankAccount(
                        new BankAccountRequest()
                            .checking()
                            .bankNumber("001")
                            .accountNumber("1234")
                            .accountCheckNumber("1")
                            .agencyNumber("4444444")
                            .agencyCheckNumber("2")
                            .holder(new HolderRequest()
                                .fullname("Nome do Portador")
                                .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                            )
                    )
                )
                .amount(2000)
        );

        assertEquals("REF-JR2WAKM894UJ", refund.getId());
        assertEquals(Refund.Status.REQUESTED, refund.getStatus());
        assertEquals(Refund.Type.PARTIAL, refund.getType());
        assertNotNull(refund.getEvents());
        assertEquals((Integer)10000, refund.getAmount().getTotal());
        assertEquals(RefundingInstrument.Method.BANK_ACCOUNT, refund.getRefundingInstrument().getMethod());
        assertEquals("https://sandbox.moip.com.br/v2/orders/ORD-XOZB2LRQ9BZ3", refund.getLinks().orderLink());
    }
}
