package br.com.moip;

import br.com.moip.authentication.Authentication;
import br.com.moip.authentication.BasicAuth;
import br.com.moip.exception.UnexpectecException;
import br.com.moip.exception.ValidationException;
import br.com.moip.resource.Order;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ClientTest {

    @Rule
    public Player player = new Player();

    private Client client;

    @Before
    public void setUp() {
        Authentication basicAuth = new BasicAuth("01010101010101010101010101010101", "ABABABABABABABABABABABABABABABABABABABAB");
        this.client = new Client(player.getURL("").toString(), basicAuth);
    }

    @Play("client/post")
    @Test
    public void testPostWhen200() {
        Order order = client.post("/200", new Order(), Order.class);
        assertNotNull(order);
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

    @Play("client/get")
    @Test
    public void testGetWhen200() {
        Order order = client.get("/200", Order.class);
        assertNotNull(order);
    }

    @Play("client/get")
    @Test
    public void testGetWhen400() {
        try {
            client.get("/400", Order.class);
            fail("Should have thrown a ValidationException");
        } catch(ValidationException e) {
            assertEquals(400, e.getResponseCode());
            assertEquals("ORD-001", e.getErrors().get(0).getCode());
        }
    }

    @Play("client/get")
    @Test(expected = UnexpectecException.class)
    public void testGetWhen500() {
        client.get("/500", Order.class);
    }

    @Test
    public void testJsonToFormEncoded() {
        String json = "{\"client_id\":\"APP-XT5FIAK2F8I7\",\"client_secret\":\"e2bd3951b87e469eb0f2c2b781a753d5\",\"code\":\"8870af1372ada7a18fdff4fa4ca1a60f4d542272\",\"redirect_uri\":\"http://localhost/test-moip-sdk-php/callback.php\"}";
        String expected = "client_id=APP-XT5FIAK2F8I7&client_secret=e2bd3951b87e469eb0f2c2b781a753d5&code=8870af1372ada7a18fdff4fa4ca1a60f4d542272&redirect_uri=http://localhost/test-moip-sdk-php/callback.php";

        assertEquals(expected, client.jsonToUrlEncodedString((JsonObject) new JsonParser().parse(json)));
    }
}