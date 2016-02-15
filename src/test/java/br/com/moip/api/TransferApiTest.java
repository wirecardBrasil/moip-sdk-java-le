package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.resource.Transfer;
import br.com.moip.response.InvoiceListResponse;
import br.com.moip.response.TransferListResponse;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransferApiTest {

    private final ClientFactory clientFactory = new ClientFactory();

    private TransferApi api;

    @Rule
    public Player player = new Player();

    @Before
    public void setUp() {
        Client client = clientFactory.client(player.getURL("").toString());
        api = new TransferApi(client);
    }

    @Play("transfers/get")
    @Test
    public void shouldGetOneTransfer() {
        Transfer createdTransfer = api.get("TRA-28HRLYNLMUFH");
        assertEquals("TRA-28HRLYNLMUFH", createdTransfer.getId());
    }

    @Play("transfers/getlist")
    @Test
    public void shouldGetTransferList() {
        TransferListResponse transferListResponse = api.getList();
        assertEquals(2, transferListResponse.getTransfers().size());
        assertEquals("TRA-08T6Z0ELJIPB", transferListResponse.getTransfers().get(0).getId());
        assertEquals("TRA-BVVSKE5K26GG", transferListResponse.getTransfers().get(1).getId());
    }

}
