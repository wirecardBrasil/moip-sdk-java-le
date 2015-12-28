package br.com.moip.api;

import br.com.moip.resource.Key;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class KeyAPITest {

    private ClientFactory clientFactory = new ClientFactory();

    private KeyAPI api;

    @Rule
    public Player player = new Player();

    @Before
    public void setup() {
//        this.api = new KeyAPI(clientFactory.client(Client.SANDBOX));
        this.api = new KeyAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Test
    @Play("keys/get")
    public void testGet() {
        Key key = api.get();

        System.out.println(key);

        assertNotNull(key.getKeys().getEncryption());
        assertNotNull(key.getKeys().getBasicAuth().getToken());
        assertNotNull(key.getKeys().getBasicAuth().getSecret());
    }
}