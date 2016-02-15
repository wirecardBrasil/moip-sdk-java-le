package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.api.filter.Pagination;
import br.com.moip.resource.Transfer;
import br.com.moip.resource.TransferStatus;
import br.com.moip.response.TransferListResponse;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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
        assertEquals("BKA-I268MOXX85BF", createdTransfer.getTransferInstrument().getBankAccount().getId());
        assertEquals(TransferStatus.REQUESTED, createdTransfer.getStatus());
    }

    @Play("transfers/list")
    @Test
    public void shouldGetTransferList() {
        TransferListResponse transferListResponse = api.list();
        assertEquals(2, transferListResponse.getTransfers().size());
        assertEquals("TRA-08T6Z0ELJIPB", transferListResponse.getTransfers().get(0).getId());
        assertEquals("BKA-RYW7ICQBW126", transferListResponse.getTransfers().get(0).getTransferInstrument().getBankAccount().getId());
        assertEquals(TransferStatus.REQUESTED, transferListResponse.getTransfers().get(0).getStatus());
        assertEquals("MPA-Y51WUXLPHBJJ", transferListResponse.getTransfers().get(1).getTransferInstrument().getMoipAccount().getId());
        assertEquals("TRA-BVVSKE5K26GG", transferListResponse.getTransfers().get(1).getId());
        assertEquals(TransferStatus.COMPLETED, transferListResponse.getTransfers().get(1).getStatus());

    }
}
