package br.com.moip.api;

import br.com.moip.resource.Account;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountAPITest {

    @Rule
    public Player player = new Player();

    private AccountAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new AccountAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Play("accounts/get")
    @Test
    public void doReturnAccount(){
        Account account = api.get();

        assertEquals("MPA-AE2OAL41CBB1", account.getId());
        assertEquals("iori@labs.moip.com.br", account.getLogin());
        assertEquals("iorilabsmoip", account.getSoftDescriptor());
        assertEquals("iori@labs.moip.com.br", account.getEmail().getAddress());
        assertEquals(false, account.isTransparentAccount());
    }
}