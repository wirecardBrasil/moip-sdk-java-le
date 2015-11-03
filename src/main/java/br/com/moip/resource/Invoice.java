package br.com.moip.resource;

import java.util.Date;

public class Invoice {
    private String id;
    private int invoiceAmount;
    private Date createdAt, updatedAt;

    private Customer customer;
    private CheckoutPreferences checkoutPreferences;
    private InvoiceStatus status;

    public Invoice() {
    }

    public Invoice(String id, int invoiceAmount, Date createdAt, Date updatedAt, Customer customer, CheckoutPreferences checkoutPreferences, InvoiceStatus status) {
        this.id = id;
        this.invoiceAmount = invoiceAmount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.customer = customer;
        this.checkoutPreferences = checkoutPreferences;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(int invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CheckoutPreferences getCheckoutPreferences() {
        return checkoutPreferences;
    }

    public void setCheckoutPreferences(CheckoutPreferences checkoutPreferences) {
        this.checkoutPreferences = checkoutPreferences;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", invoiceAmount=" + invoiceAmount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", customer=" + customer +
                ", checkoutPreferences=" + checkoutPreferences +
                ", status=" + status +
                '}';
    }
}