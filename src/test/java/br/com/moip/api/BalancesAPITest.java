package br.com.moip.api;

import br.com.moip.resource.Balances;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalancesAPITest {

    @Rule
    public Player player = new Player();

    private BalancesAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new BalancesAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Play("balances/get")
    @Test
    public void shouldGetBalances() {
        Balances balances = api.get();

        assertEquals(43902, balances.getUnavailable().getAmount());
        assertEquals("BRL", balances.getUnavailable().getCurrency());
        assertEquals(11323, balances.getFuture().getAmount());
        assertEquals("BRL", balances.getFuture().getCurrency());
        assertEquals(567094, balances.getCurrent().getAmount());
        assertEquals("BRL", balances.getCurrent().getCurrency());
    }
}
