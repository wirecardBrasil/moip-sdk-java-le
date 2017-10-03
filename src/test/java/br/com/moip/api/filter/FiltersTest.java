package br.com.moip.api.filter;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FiltersTest {

    @Test
    public void testGreaterThanFilter() {
        Filters filter = new Filters();
        filter.greaterThan("createdAt", "2017-08-17");
        assertEquals("createdAt::gt(2017-08-17)", filter.toString());
    }

    @Test
    public void testGreaterEqualFilter() {
        Filters filter = new Filters();
        filter.greaterThanOrEqual("createdAt", "2017-08-17");
        assertEquals("createdAt::ge(2017-08-17)", filter.toString());
    }

    @Test
    public void testLessThanFilter() {
        Filters filter = new Filters();
        filter.lessThan("value", "100000");
        assertEquals("value::lt(100000)", filter.toString());
    }

    @Test
    public void testInFilter() {
        Filters filter = new Filters();
        filter.in("paymentMethod", Arrays.asList(new String[] {"BOLETO","DEBIT_CARD","ONLINE_BANK_DEBIT"}));
        assertEquals("paymentMethod::in(BOLETO,DEBIT_CARD,ONLINE_BANK_DEBIT)", filter.toString());
    }

    @Test
    public void testBetweenFilter() {
        Filters filter = new Filters();
        filter.between("createdAt", "2017-08-10", "2017-08-17");

        assertEquals("createdAt::bt(2017-08-10,2017-08-17)", filter.toString());
    }

    @Test
    public void testMultipleFilter() {
        Filters filter = new Filters();
        filter.greaterThanOrEqual("createdAt", "2017-08-17");
        filter.in("paymentMethod", Arrays.asList(new String[] {"BOLETO","DEBIT_CARD"}))
            .lessThan("value", "100000");
        assertEquals("createdAt::ge(2017-08-17)|paymentMethod::in(BOLETO,DEBIT_CARD)|value::lt(100000)", filter.toString());
    }
}
