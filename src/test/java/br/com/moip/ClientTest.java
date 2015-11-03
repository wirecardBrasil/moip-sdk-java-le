package br.com.moip;

import br.com.moip.authentication.Authentication;
import br.com.moip.authentication.BasicAuth;
import br.com.moip.exception.UnexpectecException;
import br.com.moip.exception.ValidationException;
import br.com.moip.resource.Order;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ClientTest {

    @Rule
    public Player player = new Player();

    private Client client;

    @Before
    public void setup() {
        Authentication basicAuth = new BasicAuth("01010101010101010101010101010101", "ABABABABABABABABABABABABABABABABABABABAB");
        this.client = new Client(player.getURL("").toString(), basicAuth);
    }

    @Play("client/post")
    @Test
    public void testPostWhen200() {
        client.post("/200", new Order(), Order.class);
    }

    @Play("client/post")
    @Test
    public void testPostWhen400() {
        try {
            client.post("/400", new Order(), Order.class);
            fail("Should have thrown a ValidationException");
        } catch(ValidationException e) {
            assertEquals(400, e.getResponseCode());
            assertEquals("ORD-001", e.getErrors().get(0).getCode());
        }
    }

    @Play("client/post")
    @Test(expected = UnexpectecException.class)
    public void testPostWhen500() {
        client.post("/500", new Order(), Order.class);
    }
}