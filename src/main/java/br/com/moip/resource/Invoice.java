package br.com.moip.resource;

import java.util.Date;

public class Invoice {
    private String id, description;
    private int invoiceAmount;
    private Date createdAt, updatedAt;

    private Customer customer;
    private CheckoutPreferences checkoutPreferences;
    private InvoiceStatus status;
    
    public String getId() {
        return id;
    }

    public Invoice setId(String id) {
        this.id = id;
        return this;
    }

    public int getInvoiceAmount() {
        return invoiceAmount;
    }

    public Invoice setInvoiceAmount(int invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Invoice setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Invoice setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Invoice setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public CheckoutPreferences getCheckoutPreferences() {
        return checkoutPreferences;
    }

    public Invoice setCheckoutPreferences(CheckoutPreferences checkoutPreferences) {
        this.checkoutPreferences = checkoutPreferences;
        return this;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public Invoice setStatus(InvoiceStatus status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Invoice setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", invoiceAmount=" + invoiceAmount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", customer=" + customer +
                ", checkoutPreferences=" + checkoutPreferences +
                ", status=" + status +
                '}';
    }
}