package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.BoletoRequest;
import br.com.moip.request.CreditCardRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.GeolocationRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.InstructionLinesRequest;
import br.com.moip.request.MposRequest;
import br.com.moip.request.PaymentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.FundingInstrument;
import br.com.moip.resource.Payment;
import br.com.moip.resource.PaymentStatus;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PaymentAPITest {

    private static final String CC_HASH = "K+EhM5Z8ceBP5ITPNu6zsX81Fvhv+d0Rv3sKOs7misdwm00DPJbt/rPJ/M7Ii+MBv1w1W3QUVuFIRFKbInMIpua4z9IZAsNa1ESyhltbYypprCzGKk/hTkVt688oyZGaxU9Bdu+sybEik+8s6A9l7X+dAQmUdhi+aDfbf2pUiS/YNwI0xJtae0+Ldw/Ixv/21s/khdt0C38hvxjcx5DqcRF8E/xQFn8LQrF4YSPHHSr546xY2XfzE7WY7i3KAWq8dFI6XZj28FRR/hd8+j6duJFH+8pT036w2dn6CvEgSgjcoLZySHTCzTIMmJo8vJJkEH9GL//NwI3OgWzIevTzrQ==";

    private final ClientFactory clientFactory = new ClientFactory();

    private PaymentAPI api;

    @Rule
    public Player player = new Player();

    @Before
    public void setUp() {
        Client client = clientFactory.client(player.getURL("").toString());
        api = new PaymentAPI(client);
    }

    @Play("payments/create")
    @Test
    public void testCreateCreditCard() {
        Payment createdPayment = api.create(
            new PaymentRequest()
                .orderId("ORD-HPMZSOM611M2")
                .installmentCount(1)
                .fundingInstrument(
                    new FundingInstrumentRequest()
                        .creditCard(
                            new CreditCardRequest()
                                .hash(CC_HASH)
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

        assertTrue(createdPayment.getId().startsWith("PAY-KY4QPKGHZAC4"));
    }

    @Play("payments/create_boleto_payment")
    @Test
    public void testCreateBoletoRequest() {
        Payment createdPayment = api.create(
            new PaymentRequest()
                .orderId("ORD-GOHHIF4Z6PLV")
                .installmentCount(1)
                .fundingInstrument(new FundingInstrumentRequest()
                    .boleto(new BoletoRequest()
                        .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2020, Calendar.NOVEMBER, 10).getTime()))
                        .logoUri("http://logo.com")
                        .instructionLines(new InstructionLinesRequest()
                            .first("Primeira linha")
                            .second("Segunda linha")
                            .third("Terceira linha"))
                    )
                )
        );

        assertTrue(createdPayment.getId().startsWith("PAY-0UQ9BTLOXCRM"));
        assertEquals("23793.39126 60000.049464 56001.747908 8 84350000010000", createdPayment.getFundingInstrument().getBoleto().getLineCode());
        assertEquals("2020-11-10", createdPayment.getFundingInstrument().getBoleto().getExpirationDate().getFormatedDate());
        assertEquals("Primeira linha", createdPayment.getFundingInstrument().getBoleto().getInstructionLines().getFirst());
        assertEquals("Segunda linha", createdPayment.getFundingInstrument().getBoleto().getInstructionLines().getSecond());
        assertEquals("Terceira linha", createdPayment.getFundingInstrument().getBoleto().getInstructionLines().getThird());
        assertEquals(FundingInstrument.Method.BOLETO, createdPayment.getFundingInstrument().getMethod());
    }

    @Play("payments/create_mpos_credit_payment")
    @Test
    public void testCreateMposCreditRequest() {
        Payment createdPayment = api.create(
            new PaymentRequest()
                .orderId("ORD-GOHHIF4Z6PLV")
                .installmentCount(1)
                .geolocation(new GeolocationRequest()
                    .latitude(-33.867)
                    .longitude(151.206)
                )
                .fundingInstrument(new FundingInstrumentRequest()
                    .mposCreditCard(new MposRequest()
                        .PinpadId("D180")
                    )
                )
        );

        assertEquals(createdPayment.getId(), "PAY-1TUOVJ3D18NM");
        assertEquals(createdPayment.getStatus(), PaymentStatus.WAITING);
        assertEquals(createdPayment.getFundingInstrument().getMpos().getPinpadId(), "D180-64000786");
        assertEquals(createdPayment.getGeolocation().getLatitude(), -33.867, 0);
        assertEquals(createdPayment.getGeolocation().getLongitude(), 151.206,0);
    }

    @Play("payments/get")
    @Test
    public void testGetPayment() {
        Payment payment = api.get("PAY-FRAAY8GN1HSB");

        assertEquals(payment.getId(), "PAY-FRAAY8GN1HSB");
        assertEquals(payment.getStatus(), PaymentStatus.AUTHORIZED);
        assertEquals(payment.getAmount().getTotal(), (Integer)7300);
        assertEquals(payment.getFundingInstrument().getMethod(), FundingInstrument.Method.CREDIT_CARD);
        assertEquals(payment.getInstallmentCount(), 1);
    }

    @Play("payments/capture")
    @Test
    public void testCapturePayment() {
        Payment capturedPayment = api.capture("PAY-FRAAY8GN1HSB");

        assertEquals(capturedPayment.getId(), "PAY-FRAAY8GN1HSB");
        assertEquals(capturedPayment.getStatus(), PaymentStatus.AUTHORIZED);
    }

    @Play("payments/cancel_pre_authorized")
    @Test
    public void testCancelPayment() {
        Payment cancelledPayment = api.avoid("PAY-1ECF490M0E25");

        assertEquals(cancelledPayment.getId(), "PAY-1ECF490M0E25");
        assertEquals(cancelledPayment.getStatus(), PaymentStatus.CANCELLED);
    }
}
