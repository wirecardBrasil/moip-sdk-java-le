package br.com.moip.api;

import br.com.moip.api.filter.Filters;
import br.com.moip.api.filter.Pagination;
import br.com.moip.resource.Entry;
import br.com.moip.response.EntriesListResponse;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntryAPITest {

    @Rule
    public Player player = new Player();

    private EntryAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new EntryAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Play("entries/get")
    @Test
    public void shouldGetEntries() {
        Entry entry = api.get("ENT-BH4NJAVN65FB");

        assertEquals("ENT-BH4NJAVN65FB", entry.getExternalId());
        assertEquals("2017-08-25T09:53:08.000Z", entry.getScheduledFor());
        assertEquals(Entry.Status.SETTLED, entry.getStatus());
        assertEquals("MPA-B4DEE9F7589B", entry.getMoipAccount().getAccount());
        assertEquals("MPA-B4DEE9F7589B", entry.getAccountMoipAccount());
        assertEquals(179, entry.getFees().get(0).getAmount());
        assertEquals("TRANSACTION", entry.getFees().get(0).getType());
        assertEquals("CREDIT_CARD", entry.getType());
        assertEquals(2000, entry.getGrossAmount());
        assertEquals(0, entry.getMoipAccountId());
        assertEquals("2017-08-24T21:20:08.000Z", entry.getUpdatedAt());
        assertEquals(36523041, entry.getId());
        assertEquals(1, entry.getInstallment().getAmount());
        assertEquals(1, entry.getInstallment().getNumber());
        assertEquals("seu_identificador_proprio", entry.getReferences().get(0).getValue());
        assertEquals("OWN_ID", entry.getReferences().get(0).getType());
        assertEquals("ORD-6GRJQKSVAEYU", entry.getReferences().get(1).getValue());
        assertEquals("ORDER", entry.getReferences().get(1).getType());
        assertEquals("PAY-O8VM93XJICID", entry.getReferences().get(2).getValue());
        assertEquals("PAYMENT", entry.getReferences().get(2).getType());
        assertEquals("ENT-BH4NJAVN65FB", entry.getReferences().get(3).getValue());
        assertEquals("SELF", entry.getReferences().get(3).getType());
        assertEquals("PAY-O8VM93XJICID", entry.getEventId());
        assertEquals("2017-08-11T06:53:09.000Z", entry.getCreatedAt());
        assertEquals("Cartao de credito - Pedido PAY-O8VM93XJICID", entry.getDescription());
        assertEquals(false, entry.getBlocked());
        assertEquals("2017-08-24T21:20:08.000Z", entry.getSettledAt());
        assertEquals(1821, entry.getLiquidAmount());
    }

    @Play("entries/list")
    @Test
    public void shouldGetEntriesList() {
        EntriesListResponse entriesListResponse = api.list();

        assertEquals("ENT-BH4NJAVN65FB", entriesListResponse.get(0).getExternalId());
        assertEquals(2000, entriesListResponse.get(1).getGrossAmount());
        assertEquals("ORD-NHBB6G8XGJST", entriesListResponse.get(2).getReferences().get(1).getValue());
        assertEquals("ENT-HXQZX5NILT2E", entriesListResponse.get(3).getExternalId());
        assertEquals("2017-09-04T00:00:00.000Z", entriesListResponse.get(4).getScheduledFor());
    }

    @Play("entries/list-with-pagination")
    @Test
    public void shouldGetEntriesListWithPagination() {

        Pagination pagination = new Pagination();
        pagination.setLimit(10);
        pagination.setOffset(10);

        EntriesListResponse entriesListResponse = api.list(pagination);

        assertEquals("ENT-QL45ISIGQCG1", entriesListResponse.get(0).getExternalId());
        assertEquals("ENT-QDFOG120NNU2", entriesListResponse.get(1).getExternalId());
    }

    @Play("entries/list-with-all-search-params")
    @Test
    public void shouldGetEntriesListWithAllSearchParams() {

        Pagination pagination = new Pagination();
        pagination.setLimit(10);
        pagination.setOffset(10);

        Filters filters = new Filters();
        filters.between("liquidAmount","5000", "50000");

        String q = "SETTLED";

        EntriesListResponse entriesListResponse = api.list(pagination,filters,q);

        assertEquals("ENT-QL45ISIGQCG1", entriesListResponse.get(0).getExternalId());
        assertEquals(Entry.Status.SETTLED, entriesListResponse.get(1).getStatus());
        assertEquals(179, entriesListResponse.get(2).getFees().get(0).getAmount());
        assertEquals("PAY-1RPZO7YWZROC", entriesListResponse.get(3).getReferences().get(2).getValue());
    }
}
