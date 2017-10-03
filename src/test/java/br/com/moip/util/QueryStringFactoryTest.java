package br.com.moip.util;

import br.com.moip.api.filter.Filters;
import br.com.moip.api.filter.Pagination;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class QueryStringFactoryTest {

    private Pagination pagination;
    private Filters filters;

    @Before
    public void setUp() {
        ArrayList<String> status = new ArrayList<>();
        status.add("NOT_PAID");
        status.add("WAITING");

        filters = new Filters()
            .between("amount", "1000", "10000")
            .in("status", status);

        pagination = new Pagination(50, 0);
    }

    @Test
    public void testQueryStringNoParameters() {
        QueryStringFactory queryString = new QueryStringFactory("/v2/orders", null, null, null);
        assertEquals("/v2/orders", queryString.generate());
    }

    @Test
    public void testQueryStringPagination() {
        QueryStringFactory queryString = new QueryStringFactory("/v2/orders", pagination, null, null);
        assertEquals("/v2/orders?limit=50&offset=0", queryString.generate());
    }

    @Test
    public void testQueryStringPaginationFilter() {
        QueryStringFactory queryString = new QueryStringFactory("/v2/orders", pagination, filters, null);
        assertEquals("/v2/orders?limit=50&offset=0&filters=amount%3A%3Abt%281000%2C10000%29%7Cstatus%3A%3Ain%28NOT_PAID%2CWAITING%29", queryString.generate());
    }

    @Test
    public void testQueryStringAllParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", "joão silva");

        QueryStringFactory queryString = new QueryStringFactory("/v2/orders", pagination, filters, params);
        assertEquals("/v2/orders?limit=50&offset=0&filters=amount%3A%3Abt%281000%2C10000%29%7Cstatus%3A%3Ain%28NOT_PAID%2CWAITING%29&q=jo%C3%A3o+silva", queryString.generate());
    }

}
