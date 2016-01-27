package br.com.moip.api.filter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by caue.ferreira on 1/26/16.
 */
public class PaginationTest {

    @Test
    public void createFromUrl(){
        Pagination pagination = new Pagination("https://test.moip.com.br/v2/invoices?limit=30&offset=090");
        assertEquals(30, pagination.getLimit());
        assertEquals(90, pagination.getOffset());
    }
}
