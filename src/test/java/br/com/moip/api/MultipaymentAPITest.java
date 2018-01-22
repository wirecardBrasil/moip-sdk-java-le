package br.com.moip.api;

import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.BoletoRequest;
import br.com.moip.request.CreditCardRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.InstructionLinesRequest;
import br.com.moip.request.PaymentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.FundingInstrument;
import br.com.moip.resource.Multipayment;
import br.com.moip.resource.PaymentStatus;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MultipaymentAPITest {

    @Rule
    public Player player = new Player();

    private MultipaymentAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new MultipaymentAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Play("multipayment/create_boleto")
    @Test
    public void testCreateMultipaymentWithBoleto() {
        Multipayment multipayment = api.create(new PaymentRequest()
            .orderId("MOR-F2R675R1X97P")
            .installmentCount(1)
            .fundingInstrument(new FundingInstrumentRequest()
                .boleto(new BoletoRequest()
                    .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2017, Calendar.NOVEMBER, 14).getTime()))
                    .instructionLines(new InstructionLinesRequest()
                        .first("Primeira linha de instrução")
                        .second("Segunda linha de instrução")
                        .third("Terceira linha de instrução")
                    )
                    .logoUri("https://cdn.moip.com.br/wp-content/uploads/2016/05/02163352/logo-moip.png")
                )
            )
        );

        assertEquals("MPY-JMLVYS8CAQ4V", multipayment.getId());
        assertEquals(PaymentStatus.WAITING, multipayment.getStatus());
        assertEquals(FundingInstrument.Method.BOLETO, multipayment.getFundingInstrument().getMethod());
        assertEquals("2017-12-14", multipayment.getFundingInstrument().getBoleto().getExpirationDate().getFormatedDate());
        assertEquals("Primeira linha de instrução", multipayment.getFundingInstrument().getBoleto().getInstructionLines().getFirst());
        assertEquals("Segunda linha de instrução", multipayment.getFundingInstrument().getBoleto().getInstructionLines().getSecond());
        assertEquals("Terceira linha de instrução", multipayment.getFundingInstrument().getBoleto().getInstructionLines().getThird());
        assertEquals("https://checkout-sandbox.moip.com.br/boleto/MPY-JMLVYS8CAQ4V/print", multipayment.getLinks().checkout().getPayBoletoPrintLink());
        assertEquals("https://checkout-sandbox.moip.com.br/boleto/MPY-JMLVYS8CAQ4V", multipayment.getLinks().checkout().getPayBoletoLink());
    }

    @Play("multipayment/create_cc")
    @Test
    public void testCreateMultipaymentWithCreditCard() {
        Multipayment multipayment = api.create(new PaymentRequest()
            .orderId("MOR-BMJN4E5LSG6N")
            .installmentCount(1)
            .statementDescriptor("Minha Loja")
            .delayCapture(false)
            .fundingInstrument(
                new FundingInstrumentRequest()
                    .creditCard(
                        new CreditCardRequest()
                            .number("4012001037141112")
                            .cvc(123)
                            .expirationMonth("05")
                            .expirationYear("18")
                            .holder(
                                new HolderRequest()
                                    .fullname("Jose Portador da Silva")
                                    .birthdate("1988-10-10")
                                    .phone(
                                        new PhoneRequest()
                                            .setAreaCode("11")
                                            .setNumber("55667788")
                                    )
                                    .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                            )
                    )
            )
        );

        assertEquals("MPY-OUGA0AHH2BOF", multipayment.getId());
        assertEquals(PaymentStatus.WAITING, multipayment.getStatus());
        assertEquals(FundingInstrument.Method.CREDIT_CARD, multipayment.getPayments().get(0).getFundingInstrument().getMethod());
        assertEquals((Integer)4000, multipayment.getPayments().get(0).getAmount().getTotal());
        assertEquals((Integer)4000, multipayment.getPayments().get(1).getAmount().getTotal());
        assertEquals("https://sandbox.moip.com.br/v2/multiorders/MOR-BMJN4E5LSG6N", multipayment.getLinks().multiorderLink());
        assertEquals("VISA", multipayment.getPayments().get(0).getFundingInstrument().getCreditCard().getBrand());
        assertEquals("Minha Loja", multipayment.getPayments().get(0).getStatementDescriptor());
        assertEquals("Minha Loja", multipayment.getPayments().get(1).getStatementDescriptor());
    }

    @Play("multipayment/get")
    @Test
    public void testGetMultipayment() {
        Multipayment multipayment = api.get("MPY-OUGA0AHH2BOF");

        assertEquals("MPY-OUGA0AHH2BOF", multipayment.getId());
        assertEquals(PaymentStatus.PRE_AUTHORIZED, multipayment.getStatus());
        assertEquals((Integer)8000, multipayment.getAmount().getTotal());
        assertEquals(1, multipayment.getInstallmentCount());
        assertNotNull(multipayment.getPayments());
        assertEquals("Minha Loja", multipayment.getPayments().get(0).getStatementDescriptor());
        assertEquals("Minha Loja", multipayment.getPayments().get(1).getStatementDescriptor());
    }

    @Play("multipayment/capture")
    @Test
    public void testCaptureMultipayment() {
        Multipayment multipayment = api.capture("MPY-UGZLJMVJ37LX");

        assertEquals("MPY-UGZLJMVJ37LX", multipayment.getId());
        assertEquals((Integer)8000, multipayment.getAmount().getTotal());
        assertEquals(PaymentStatus.AUTHORIZED, multipayment.getStatus());
    }

    @Play("multipayment/cancel_pre_authorized")
    @Test
    public void testCancelMultipayment() {
        Multipayment cancelledPayment = api.cancelPreAuthorized("MPY-YDNM3U17OSDD");

        assertEquals("MPY-YDNM3U17OSDD", cancelledPayment.getId());
        assertEquals(PaymentStatus.CANCELLED, cancelledPayment.getStatus());
    }

    @Play("multipayment/create_escrow")
    @Test
    public void testCreateWithEscrow() {
        Multipayment createWithEscrow = api.create(new PaymentRequest()
            .orderId("MOR-T1F8O64DLS4X")
            .installmentCount(1)
            .escrow(new PaymentRequest.EscrowRequest("Teste de Descrição"))
            .delayCapture(false)
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .number("4012001037141112")
                    .cvc(123)
                    .expirationMonth("05")
                    .expirationYear("18")
                    .holder(new HolderRequest()
                        .fullname("Jose Portador da Silva")
                        .birthdate("1988-10-10")
                        .phone(new PhoneRequest()
                            .setAreaCode("11")
                            .setNumber("55667788")
                        )
                        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    )
                )
            )
        );

        assertEquals("MPY-TUZUG6A4AHLF", createWithEscrow.getId());
        assertEquals("ECW-RI6HTOU2M4DY", createWithEscrow.getPayments().get(0).getEscrowId());
    }

}
