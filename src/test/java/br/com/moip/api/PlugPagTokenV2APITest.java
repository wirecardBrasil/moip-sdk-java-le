package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.PlugPagTokenV2API;
import br.com.moip.response.PlugPagTokenResponse;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlugPagTokenV2APITest {

    private final ClientFactory clientFactory = new ClientFactory();

    PlugPagTokenV2API plugPagTokenV2API;

    @Rule
    public Player player = new Player();

    @Before
    public void setUp() {
        Client client = clientFactory.client(player.getURL("").toString());
        plugPagTokenV2API = new PlugPagTokenV2API(client);
    }

    @Play("/plugpag_token/get_tokenv2")
    @Test
    public void get() {
        PlugPagTokenResponse response = plugPagTokenV2API.get();

        assertEquals("meutoken",response.getToken());
    }

}
