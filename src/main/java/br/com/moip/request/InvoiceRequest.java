package br.com.moip.request;

public class InvoiceRequest {

    private String description;
    private int invoiceAmount;

    private CustomerRequest customer;
    private CheckoutPreferencesRequest checkoutPreferences;

    public int getInvoiceAmount() {
        return invoiceAmount;
    }

    public InvoiceRequest invoiceAmount(final int invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
        return this;
    }

    public CustomerRequest getCustomer() {
        return customer;
    }

    public InvoiceRequest customer(final CustomerRequest customer) {
        this.customer = customer;
        return this;
    }

    public CheckoutPreferencesRequest getCheckoutPreferences() {
        return checkoutPreferences;
    }

    public InvoiceRequest checkoutPreferences(final CheckoutPreferencesRequest checkoutPreferences) {
        this.checkoutPreferences = checkoutPreferences;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InvoiceRequest description(final String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder("InvoiceRequest{")
                .append("description='").append(description).append('\'')
                .append(", invoiceAmount=").append(invoiceAmount)
                .append(", customer=").append(customer)
                .append(", checkoutPreferences=").append(checkoutPreferences)
                .append('}').toString();
    }
}