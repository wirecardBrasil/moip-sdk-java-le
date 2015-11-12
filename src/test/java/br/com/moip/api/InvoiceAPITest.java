package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.authentication.BasicAuth;
import br.com.moip.resource.CheckoutPreferences;
import br.com.moip.resource.Customer;
import br.com.moip.resource.FundingInstrument;
import br.com.moip.resource.Invoice;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceAPITest {

    @Rule
    public Player player = new Player();

    private InvoiceAPI api;

    @Before
    public void setUp() {
        api = new InvoiceAPI(new Client(player.getURL("").toString(), new BasicAuth("01010101010101010101010101010101", "ABABABABABABABABABABABABABABABABABABABAB")));
    }

    @Play("invoices/create")
    @Test
    public void testCreate() {

        Invoice invoiceCreated = api.create(
                new Invoice()
                        .setInvoiceAmount(12610).setDescription("teste")
                        .setCustomer(
                                new Customer()
                                        .setEmail("vagner.vieira@moip.com.br"))
                        .setCheckoutPreferences(
                                new CheckoutPreferences()
                                        .setFundingInstruments(
                                                new FundingInstrument()
                                                        .setSupressBoleto(true))
                                        .addInstallment(
                                                new int[]{1, 2})
                                        .addInstallment(
                                                new int[]{6, 9}).
                                        setSupressShippingAddress(true)));

        assertEquals("INV-7761BDB06412", invoiceCreated.getId());
    }
}