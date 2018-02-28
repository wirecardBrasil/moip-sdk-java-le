package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.exception.ValidationException;
import br.com.moip.request.*;
import br.com.moip.resource.*;
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
    }

    @Play("transfers/create_with_bank_account_id")
    @Test
    public void shouldCreateATransferWithBankAccountId() {
        Transfer transfer = api.create(transferRequest);

        assertEquals(200, transfer.getFee());
        assertEquals(500, transfer.getAmount());
        assertEquals("TRA-R04VZMAXH53X", transfer.getId());
        assertEquals(TransferInstrument.Method.BANK_ACCOUNT, transfer.getTransferInstrument().getMethod());
        assertEquals("BKA-QQS207YFQ466", transfer.getTransferInstrument().getBankAccount().getId());
        assertEquals("1111", transfer.getTransferInstrument().getBankAccount().getAgencyNumber());
        assertEquals("430.409.248-00", transfer.getTransferInstrument().getBankAccount().getHolder().getTaxDocument().getNumber());
        assertEquals(TaxDocument.Type.CPF, transfer.getTransferInstrument().getBankAccount().getHolder().getTaxDocument().getType());
        assertEquals("Matheus Barbosa Nakaya", transfer.getTransferInstrument().getBankAccount().getHolder().getFullname());
        assertEquals("9999", transfer.getTransferInstrument().getBankAccount().getAccountNumber());
        assertEquals("8", transfer.getTransferInstrument().getBankAccount().getAccountCheckNumber());
        assertEquals("BANCO DO BRASIL S.A.", transfer.getTransferInstrument().getBankAccount().getBankName());
        assertEquals(BankAccount.Type.CHECKING, transfer.getTransferInstrument().getBankAccount().getType());
        assertEquals("2", transfer.getTransferInstrument().getBankAccount().getAgencyCheckNumber());
        assertEquals("001", transfer.getTransferInstrument().getBankAccount().getBankNumber());
        assertEquals(TransferStatus.REQUESTED, transfer.getStatus());
        assertEquals("Requested", transfer.getEvents().get(0).getDescription());
        assertEquals("TRANSFER.REQUESTED", transfer.getEvents().get(0).getType());
        assertEquals("ENT-TSBYJTJT5P8L", transfer.getEntries().get(0).getExternalId());
        assertEquals(Entry.Status.SETTLED, transfer.getEntries().get(0).getStatus());
        assertEquals("MPA-5D5053C0B4A4", transfer.getEntries().get(0).getMoipAccount().getAccount());
        assertEquals("TRANSFER_TO_BANK_ACCOUNT", transfer.getEntries().get(0).getType());
        assertEquals(-500, transfer.getEntries().get(0).getGrossAmount());
        assertEquals(260863, transfer.getEntries().get(0).getMoipAccountId());
        assertEquals(36714066, transfer.getEntries().get(0).getId());
        assertEquals(1, transfer.getEntries().get(0).getInstallment().getAmount());
        assertEquals(1, transfer.getEntries().get(0). getInstallment().getNumber());
        assertEquals("APP-QGAGZRIX1CUF", transfer.getEntries().get(0).getReferences().get(0).getValue());
        assertEquals("CHANNEL", transfer.getEntries().get(0).getReferences().get(0).getType());
        assertEquals("TRA-R04VZMAXH53X", transfer.getEntries().get(0).getEventId());
        assertEquals("Transferencia para conta bancaria - TRA-R04VZMAXH53X", transfer.getEntries().get(0).getDescription());
        assertEquals(false, transfer.getEntries().get(0).getBlocked());
        assertEquals(-500, transfer.getEntries().get(0).getLiquidAmount());
        assertEquals(Transfer.Role.PAYER, transfer.getRole());
        assertEquals("https://sandbox.moip.com.br/v2/transfers/TRA-R04VZMAXH53X", transfer.getLinks().getSelf());
    }

    @Play("transfers/validation_exception")
    @Test(expected = ValidationException.class)
    public void shouldFailOnCreateATransfer() {
        Transfer transferTest = api.create(new TransferRequest()
                .amount(500)
                .transferInstrument(new TransferInstrumentRequest()
                        .bankAccount(new BankAccountRequest()
                                .bankNumber("001")
                                .agencyNumber("1111")
                                .agencyCheckNumber("2")
                                .accountNumber("9999")
                                .accountCheckNumber("8")
                                .holder(new HolderRequest()
                                        .fullname("Fulano Sem Nome")
                                        .taxDocument(TaxDocumentRequest.cpf(null))
                                )
                        )
                )
        );
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
