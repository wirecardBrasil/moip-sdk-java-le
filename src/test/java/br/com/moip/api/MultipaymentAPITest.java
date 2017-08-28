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
                    .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2017, Calendar.SEPTEMBER, 30).getTime()))
                    .instructionLines(new InstructionLinesRequest()
                        .first("Primeira linha se instrução")
                        .second("Segunda linha se instrução")
                        .third("Terceira linha se instrução")
                    )
                    .logoUri("http://")
                )
            )
        );

        assertEquals("MPY-VVVF0YDCY15H", multipayment.getId());
        assertEquals(PaymentStatus.WAITING, multipayment.getStatus());
        assertEquals(FundingInstrument.Method.BOLETO, multipayment.getFundingInstrument().getMethod());
        assertEquals("2017-09-30", multipayment.getFundingInstrument().getBoleto().getExpirationDate().getFormatedDate());
        assertEquals("Primeira linha se instrução", multipayment.getFundingInstrument().getBoleto().getInstructionLines().getFirst());
        assertEquals("Segunda linha se instrução", multipayment.getFundingInstrument().getBoleto().getInstructionLines().getSecond());
        assertEquals("Terceira linha se instrução", multipayment.getFundingInstrument().getBoleto().getInstructionLines().getThird());
    }

    @Play("multipayment/create_cc")
    @Test
    public void testCreateMultipaymentWithCreditCard() {
        Multipayment multipayment = api.create(new PaymentRequest()
            .orderId("MOR-BMJN4E5LSG6N")
            .installmentCount(1)
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
    }
}
