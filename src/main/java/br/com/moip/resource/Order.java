package br.com.moip.resource;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private Amount amount;
    private String ownId;
    private final List<Item> items;
    private Customer customer;
    private final List<Receiver> receivers = new ArrayList<>();
    @SerializedName("_links") private Links links;

    public String getId() {
        return id;
    }

    public Amount getAmount() {
        return amount;
    }

    public String getOwnId() {
        return ownId;
    }

    public List<Item> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Receiver> getReceivers() {
        return receivers;
    }

    public Links getLinks() {
        return links;
    }

    public Order(){
        items = new ArrayList<Item>();
    }

    protected Order(final Order order){
        this.id = order.getId();
        this.amount = order.getAmount();
        this.ownId = order.getOwnId();
        this.customer = order.getCustomer();
        this.items = order.getItems();
    }

    @Override
    public String toString() {
        return new StringBuilder("Order{")
                .append("id='").append(id).append('\'')
                .append(", amount=").append(amount)
                .append(", ownId='").append(ownId).append('\'')
                .append(", items=").append(items)
                .append(", customer=").append(customer)
                .append(", receivers=").append(receivers)
                .append(", links=").append(links)
                .append('}').toString();
    }

    public static final class Item {
        private String product;
        private Integer quantity;
        private String detail;
        private Integer price;

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

        @Override
        public String toString() {
            return new StringBuilder("Item{")
                    .append("product='").append(product).append('\'')
                    .append(", quantity=").append(quantity)
                    .append(", detail='").append(detail).append('\'')
                    .append(", price=").append(price)
                    .append('}').toString();
        }
    }
    
    public static final class Links {
        private Checkout checkout;

        public Checkout getCheckout() {
            return checkout;
        }

        public void setCheckout(Checkout checkout) {
            this.checkout = checkout;
        }

        @Override
        public String toString() {
            return new StringBuilder("Links{")
                    .append("checkout=").append(checkout).append('}').toString();
        }
    }
}
