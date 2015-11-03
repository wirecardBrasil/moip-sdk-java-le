package br.com.moip.resource;

public enum InvoiceStatus {
    SENT("SENT"), PAID("PAID");

    private String status;

    InvoiceStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}