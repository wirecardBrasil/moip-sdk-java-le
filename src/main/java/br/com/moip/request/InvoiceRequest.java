package br.com.moip.request;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRequest {

    private List<ItemRequest> items = new ArrayList<>();
    private CustomerRequest customer;
    private CheckoutPreferencesRequest checkoutPreferences;

    public InvoiceRequest addItem(final String product, final Integer quantity, final String detail, final Integer price) {
        this.items.add(new ItemRequest(product, quantity, detail, price));
        return this;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public InvoiceRequest customer(final CustomerRequest customer) {
        this.customer = customer;
        return this;
    }

    public CustomerRequest getCustomer() {
        return customer;
    }

    public InvoiceRequest checkoutPreferences(final CheckoutPreferencesRequest checkoutPreferences) {
        this.checkoutPreferences = checkoutPreferences;
        return this;
    }

    public CheckoutPreferencesRequest getCheckoutPreferences() {
        return checkoutPreferences;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InvoiceRequest{");
        sb.append("items=").append(items);
        sb.append(", customer=").append(customer);
        sb.append(", checkoutPreferences=").append(checkoutPreferences);
        sb.append('}');
        return sb.toString();
    }
}