package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.response.PlugPagTokenResponse;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlugPagTokenAPITest {

    private final ClientFactory clientFactory = new ClientFactory();

    PlugPagTokenAPI plugPagTokenAPI;

    @Rule
    public Player player = new Player();

    @Before
    public void setUp() {
        Client client = clientFactory.client(player.getURL("").toString());
        plugPagTokenAPI = new PlugPagTokenAPI(client);
    }

    @Play("/plugpag_token/get_token")
    @Test
    public void get() {
        PlugPagTokenResponse response = plugPagTokenAPI.get();

        assertEquals("meutoken",response.getToken());
    }
}
