package br.com.moip.resource;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String ownId;
    private final List<Item> items = new ArrayList<Item>();
    private Customer customer;
    private String id;
    private Amount amount;

    public String getOwnId() {
        return ownId;
    }

    public Order setOwnId(String ownId) {
        this.ownId = ownId;

        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public Order addItem(final String product, final Integer quantity, final String detail, final Integer price) {
        items.add(new Item(product, quantity, detail, price));

        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(final Customer customer) {
        this.customer = customer;

        return this;
    }

    public String getId() {
        return id;
    }

    public Amount getAmount() {
        return amount;
    }

    public static final class Item {
        private final String product;
        private final Integer quantity;
        private final String detail;
        private final Integer price;

        public Item(String product, Integer quantity, String detail, Integer price) {
            this.product = product;
            this.quantity = quantity;
            this.detail = detail;
            this.price = price;
        }

        public String getProduct() {
            return product;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public String getDetail() {
            return detail;
        }

        public Integer getPrice() {
            return price;
        }
    }
}
