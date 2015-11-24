package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.CreditCardRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.PaymentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.Payment;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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
                                                                        .setPhone(
                                                                                new PhoneRequest()
                                                                                        .setAreaCode("11")
                                                                                        .setNumber("55667788")
                                                                        )
                                                                        .setTaxDocument(TaxDocumentRequest.cpf("22222222222"))
                                                        )
                                        )
                        )

        );

        assertTrue(createdPayment.getId().startsWith("PAY-KY4QPKGHZAC4"));
    }
}