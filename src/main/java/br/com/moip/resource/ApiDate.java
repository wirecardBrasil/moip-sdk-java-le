package br.com.moip.resource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiDate {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormatedDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(this.getDate());
    }
}
