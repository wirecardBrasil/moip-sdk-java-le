package br.com.moip.api.filter;

public class Pagination {

    private int offset, limit;

    public Pagination(){

    }

    public Pagination (int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public Pagination(final String url) {
        String[] params = url.split("&");
        String limit = params[0].split("=")[1];
        String offset = params[1].split("=")[1];


        this.limit = Integer.parseInt(limit);
        this.offset = Integer.parseInt(offset);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}