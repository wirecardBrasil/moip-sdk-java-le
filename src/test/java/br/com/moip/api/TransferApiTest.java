package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.TransferRequest;

import br.com.moip.resource.Transfer;
import br.com.moip.resource.TransferInstrument;
import br.com.moip.resource.TransferStatus;
import br.com.moip.response.TransferListResponse;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TransferApiTest {

    private final ClientFactory clientFactory = new ClientFactory();

    private TransferApi api;

    @Rule
    public Player player = new Player();
    private TransferRequest transferRequest;

    @Before
    public void setUp() {
        Client client = clientFactory.client(player.getURL("").toString());
        api = new TransferApi(client);
        transferRequest = new TransferRequest();
    }

    @Play("transfers/create")
    @Test
    public void shouldCreateATransfer() {
        Transfer transfer = api.create(transferRequest);

        assertEquals("TRA-28HRLYNLMUFH", transfer.getId());
        assertEquals(500, transfer.getAmount());
        assertEquals(TransferInstrument.Method.BANK_ACCOUNT, transfer.getTransferInstrument().getMethod());
        assertEquals("BKA-I268MOXX85BF", transfer.getTransferInstrument().getBankAccount().getId());
        assertEquals("1111", transfer.getTransferInstrument().getBankAccount().getAgencyNumber());
        assertEquals("033.575.852-51", transfer.getTransferInstrument().getBankAccount().getHolder().getTaxDocument().getNumber());
        assertEquals("Integração Taxa por canal", transfer.getTransferInstrument().getBankAccount().getHolder().getFullname());
        assertEquals("9999", transfer.getTransferInstrument().getBankAccount().getAccountNumber());
        assertEquals("8", transfer.getTransferInstrument().getBankAccount().getAccountCheckNumber());
        assertEquals("2", transfer.getTransferInstrument().getBankAccount().getAgencyCheckNumber());
        assertEquals("BANCO DO BRASIL S.A.", transfer.getTransferInstrument().getBankAccount().getBankName());
        assertEquals("001", transfer.getTransferInstrument().getBankAccount().getBankNumber());
        assertEquals(TransferStatus.REQUESTED, transfer.getStatus());
        assertEquals("https://sandbox.moip.com.br/v2/transfers/TRA-28HRLYNLMUFH", transfer.getLinks().getSelf());
        assertNotEquals("TRA-28HRLYNLMUFI", transfer.getId());
        assertNotEquals(5000, transfer.getAmount());
        assertNotEquals("BKA-I268MOXX85BG", transfer.getTransferInstrument().getBankAccount().getId());
        assertNotEquals("133.575.852-51", transfer.getTransferInstrument().getBankAccount().getHolder().getTaxDocument().getNumber());
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
        assertEquals(Transfer.Role.PAYER, transferListResponse.getTransfers().get(0).getRole());
        assertEquals("MPA-Y51WUXLPHBJJ", transferListResponse.getTransfers().get(1).getTransferInstrument().getMoipAccount().getId());
        assertEquals("TRA-BVVSKE5K26GG", transferListResponse.getTransfers().get(1).getId());
        assertEquals(TransferStatus.COMPLETED, transferListResponse.getTransfers().get(1).getStatus());
        assertEquals(Transfer.Role.RECEIVER, transferListResponse.getTransfers().get(1).getRole());
    }

    @Play("transfers/reverse")
    @Test
    public void shouldReverseATransfer() {
        Transfer revertTransfer = api.reverse("TRA-B0W5FD5FCADG");
        assertEquals(0, revertTransfer.getFee());
        assertEquals(1000, revertTransfer.getAmount());
        assertEquals("TRA-B0W5FD5FCADG", revertTransfer.getId());
        assertEquals("MPA-AE2OAL41CBB1", revertTransfer.getTransferInstrument().getMoipAccount().getId());
        assertEquals("iori@labs.moip.com.br", revertTransfer.getTransferInstrument().getMoipAccount().getLogin());
        assertEquals("iori@labs.moip.com.br", revertTransfer.getTransferInstrument().getMoipAccount().getEmail());
        assertEquals("Iori Yagami", revertTransfer.getTransferInstrument().getMoipAccount().getFullname());
        assertEquals(TransferInstrument.Method.MOIP_ACCOUNT, revertTransfer.getTransferInstrument().getMethod());
        assertEquals(TransferStatus.REVERSED, revertTransfer.getStatus());
        assertEquals("https://sandbox.moip.com.br/v2/transfers/TRA-B0W5FD5FCADG", revertTransfer.getLinks().getSelf());
    }
}
