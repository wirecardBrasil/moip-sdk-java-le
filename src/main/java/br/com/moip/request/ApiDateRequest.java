package br.com.moip.request;

import java.util.Date;

public class ApiDateRequest {
    private Date date;

    public Date getDate() {
        return date;
    }

    public ApiDateRequest date(Date date) {
        this.date = date;

        return this;
    }
}
