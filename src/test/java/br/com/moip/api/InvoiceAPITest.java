package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.authentication.BasicAuth;
import br.com.moip.request.CheckoutPreferencesRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.InvoiceRequest;
import br.com.moip.resource.Invoice;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

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
                new InvoiceRequest()
                        .invoiceAmount(12610)
                        .description("teste")
                        .customer(
                                new CustomerRequest()
                                        .email("vagner.vieira@moip.com.br"))
                        .checkoutPreferences(
                                new CheckoutPreferencesRequest()
                                        .fundingInstruments(
                                                new FundingInstrumentRequest()
                                                        .supressBoleto(true))
                                        .addInstallment(
                                                new int[]{1, 2})
                                        .addInstallment(
                                                new int[]{6, 9})
                                        .supressShippingAddress(true)));

        assertEquals("INV-7761BDB06412", invoiceCreated.getId());
    }

    @Play("invoices/get")
    @Test
    public void testGet() {
        Invoice invoice = api.get("INV-7761BDB06412");

        assertEquals("INV-7761BDB06412", invoice.getId());
    }

    @Play("invoices/list")
    @Test
    public void testList() {
        List<Invoice> invoiceList = api.list();

        assertEquals(3, invoiceList.size());
    }

    @Play("invoices/list_limit_5")
    @Test
    public void testListLimit() {
        List<Invoice> invoiceList = api.list(5);

        assertEquals(3, invoiceList.size());
    }
}