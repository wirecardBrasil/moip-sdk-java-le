package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.api.filter.Pagination;
import br.com.moip.authentication.BasicAuth;
import br.com.moip.request.CheckoutPreferencesRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.InvoiceRequest;
import br.com.moip.request.ItemRequest;
import br.com.moip.resource.Invoice;
import br.com.moip.response.InvoiceListResponse;
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
                new InvoiceRequest()
                        .addItem("My Invoice Product", 1, "My Invoice Detail", 1000)
                        .customer(
                                new CustomerRequest()
                                        .email("vavagner.vieira@moip.com.br"))
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

        assertEquals("INV-B36128A22351", invoiceCreated.getId());
        assertEquals(Integer.valueOf(1000), invoiceCreated.getAmount().getTotal());
        assertEquals("My Invoice Product", invoiceCreated.getItems().get(0).getProduct());
        assertEquals("My Invoice Detail", invoiceCreated.getItems().get(0).getDetail());
    }

    @Play("invoices/get")
    @Test
    public void testGet() {
        Invoice invoice = api.get("INV-CA56C3217FA8");

        assertEquals("INV-CA56C3217FA8", invoice.getId());
    }

    @Play("invoices/list")
    @Test
    public void testList() {
        InvoiceListResponse response = api.list();

        assertEquals(3, response.getInvoices().size());
    }

    @Play("invoices/list_limit_5")
    @Test
    public void testListLimit() {
        Pagination pagination = new Pagination();
        pagination.setLimit(5);
        InvoiceListResponse invoiceListResponse = api.list(pagination);

        assertEquals(5, invoiceListResponse.getInvoices().size());
    }
}