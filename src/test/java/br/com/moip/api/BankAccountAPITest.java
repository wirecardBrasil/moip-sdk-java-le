package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.BankAccountRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.BankAccount;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BankAccountAPITest {

    private final ClientFactory clientFactory = new ClientFactory();

    private BankAccountsAPI api;

    @Rule
    public Player player = new Player();

    @Before
    public void setUp() {
        Client client = clientFactory.client(player.getURL("").toString());
        api = new BankAccountsAPI(client);
    }


    @Play("bankaccounts/create")
    @Test
    public void testBankAccount() {

        BankAccount createdBankAccount = api.create("MPA-E0BAC6D15696",
                new BankAccountRequest()
                        .bankNumber("237")
                        .agencyNumber("12346")
                        .agencyCheckNumber("0")
                        .accountNumber("12345679")
                        .accountCheckNumber("7")
                        .checking()
                        .holder(new HolderRequest()
                                .fullname("Vagner")
                                .taxDocument(TaxDocumentRequest.cpf("22222222222")
                                )
                        )
        );
        assertTrue(createdBankAccount.getId().startsWith("BKA-"));
    }

}
