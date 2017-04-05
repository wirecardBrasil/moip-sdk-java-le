package br.com.moip.resource;

import java.util.Date;
import java.util.List;

public class Invoice {

    private String id;
    private Amount amount;
    private List<Item> items;
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

    public Amount getAmount() {
        return amount;
    }

    public Invoice setAmount(Amount amount) {
        this.amount = amount;
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

    public List<Item> getItems() {
        return items;
    }

    public Invoice setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Invoice{");
        sb.append("id='").append(id).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", items=").append(items);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", customer=").append(customer);
        sb.append(", checkoutPreferences=").append(checkoutPreferences);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}