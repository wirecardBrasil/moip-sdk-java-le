package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.BankAccountRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.BankAccount;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void shouldCreateBankAccount() {

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

    @Play("bankaccounts/get")
    @Test
    public void shouldGetOneAccount() {
        BankAccount createdBankAccount = api.get("BKA-P9O93Z6PKUTI");
        assertEquals("BKA-P9O93Z6PKUTI", createdBankAccount.getId());
    }

    @Play("bankaccounts/getlist")
    @Test
    public void shouldGetAccountList() {
        List<BankAccount> createdBankAccounts = api.getList("MPA-E0BAC6D15696");
        assertEquals(4, createdBankAccounts.size());
        assertEquals("BKA-P9O93Z6PKUTI", createdBankAccounts.get(0).getId());
        assertEquals("BKA-W2WWYEI9GKG1", createdBankAccounts.get(1).getId());
        assertEquals("BKA-RVJI1DX9N5SU", createdBankAccounts.get(2).getId());
        assertEquals("BKA-WX44D0AEV2NH", createdBankAccounts.get(3).getId());
    }

    @Play("bankaccounts/update")
    @Test
    public void shouldUpdateBankAccount() {
    	BankAccount createdBankAccount = api.update("BKA-E0BAC6D15696",
            new BankAccountRequest()
                .bankNumber("237")
                .agencyNumber("12345")
                .agencyCheckNumber("8")
                .accountNumber("12345678")
                .accountCheckNumber("8")
                .checking()
                .holder(
                    new HolderRequest()
                    .fullname("Demo Moip")
                    .taxDocument(
                        TaxDocumentRequest.cpf("62213453322")
                    )
                )
		);
    	assertTrue(createdBankAccount.getId().startsWith("BKA-"));
    }
    
    @Play("bankaccounts/delete")
    @Test
    public void shouldDeleteBankAccount() {
    	assertTrue(api.delete("BKA-E0BAC6D15696"));
    }
}
