package br.com.moip.api;

import br.com.moip.resource.Escrow;
import br.com.moip.resource.EscrowStatus;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EscrowAPITest {

    @Rule
    public Player player = new Player();

    private EscrowAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new EscrowAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Play("escrow/release")
    @Test
    public void testCreate() {
        Escrow escrowReleased = api.release("ECW-S0QEDXJM7TXT");

        assertEquals(EscrowStatus.RELEASED, escrowReleased.getStatus());
        assertEquals("ECW-S0QEDXJM7TXT", escrowReleased.getId());
        assertEquals((Integer)7300, escrowReleased.getAmount());
        assertEquals("Teste de descricao", escrowReleased.getDescription());
        assertEquals("https://aws-sand-gapi-01c.moip.in/v2/escrows/ECW-S0QEDXJM7TXT", escrowReleased.getLinks().self());
        assertEquals("https://aws-sand-gapi-01c.moip.in/v2/orders/ORD-3435DIB58HYN", escrowReleased.getLinks().orderLink());
        assertEquals("ORD-3435DIB58HYN", escrowReleased.getLinks().orderTitle());
        assertEquals("https://aws-sand-gapi-01c.moip.in/v2/payments/PAY-LDHXW5P34766", escrowReleased.getLinks().paymentLink());
        assertEquals("PAY-LDHXW5P34766", escrowReleased.getLinks().paymentTitle());


    }
}
