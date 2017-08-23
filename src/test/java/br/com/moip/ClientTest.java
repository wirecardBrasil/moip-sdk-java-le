package br.com.moip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.DataOutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import br.com.moip.request.RequestTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.powermock.api.mockito.PowerMockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;

import br.com.moip.authentication.Authentication;
import br.com.moip.authentication.BasicAuth;
import br.com.moip.exception.UnexpectecException;
import br.com.moip.exception.ValidationException;
import br.com.moip.resource.Order;
import br.com.moip.ssl.SSLSupport;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Client.class, URL.class, SSLContext.class})
public class ClientTest extends RequestTest{

    @Rule
    public Player player = new Player();

    private Client client;

    @Before
    public void setUp() {
        Authentication basicAuth = new BasicAuth("01010101010101010101010101010101", "ABABABABABABABABABABABABABABABABABABABAB");
        this.client = new Client(player.getURL("").toString(), basicAuth);
    }
    
    @Test
    public void testSSLSupport() throws Exception {
    	URL urlMock = mock(URL.class);
    	HttpsURLConnection httpsMock = mock(HttpsURLConnection.class);
    	
    	whenNew(URL.class).withAnyArguments().thenReturn(urlMock);
    	when(urlMock.openConnection()).thenReturn(httpsMock);
    	
    	doCallRealMethod().when(httpsMock).setSSLSocketFactory(any(SSLSocketFactory.class));
    	when(httpsMock.getSSLSocketFactory()).thenCallRealMethod();
    	when(httpsMock.getURL()).thenReturn(urlMock);
    	when(httpsMock.getOutputStream()).thenReturn(mock(DataOutputStream.class));
    	
    	SSLContext context = mock(SSLContext.class);

        mockStatic(SSLContext.class);
        when(SSLContext.getInstance("TLS")).thenReturn(context);
    	
        client.post("/200", new Order(), Order.class);
        
        SSLSocketFactory sslSocketFactory = httpsMock.getSSLSocketFactory();
        assertTrue(sslSocketFactory instanceof SSLSupport);
        
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
        String expected = "client_id=APP-XT5FIAK2F8I7&client_secret=e2bd3951b87e469eb0f2c2b781a753d5&code=8870af1372ada7a18fdff4fa4ca1a60f4d542272&redirect_uri=http%3A%2F%2Flocalhost%2Ftest-moip-sdk-php%2Fcallback.php";

        assertEquals(expected, client.jsonToUrlEncodedString(getJsonFileAsJsonObject("connect/generate_token.json")));
    }

    @Test
    public void testJsonToFormEncodedWithSubObject() {
        String expected = "orderId=ORD-GOHHIF4Z6PLV&installmentCount=1&fundingInstrument[method]=BOLETO&fundingInstrument[boleto][expirationDate]=2020-11-10&fundingInstrument[boleto][instructionLines][first]=Primeira+linha&fundingInstrument[boleto][instructionLines][second]=Segunda+linha&fundingInstrument[boleto][instructionLines][third]=Terceira+linha&fundingInstrument[boleto][logoUri]=http%3A%2F%2Flogo.com&fundingInstrument[suppressBoleto]=false&fundingInstrument[suppressCreditCard]=false";

        assertEquals(expected, client.jsonToUrlEncodedString(getJsonFileAsJsonObject("payment/create_boleto.json")));
    }
}