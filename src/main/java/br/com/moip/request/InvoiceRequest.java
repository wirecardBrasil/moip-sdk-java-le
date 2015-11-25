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
        final StringBuilder sb = new StringBuilder("InvoiceRequest{");
        sb.append("description='").append(description).append('\'');
        sb.append(", invoiceAmount=").append(invoiceAmount);
        sb.append(", customer=").append(customer);
        sb.append(", checkoutPreferences=").append(checkoutPreferences);
        sb.append('}');
        return sb.toString();
    }
}