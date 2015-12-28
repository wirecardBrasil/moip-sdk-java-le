package br.com.moip.resource;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private Amount amount;
    private String ownId;
    private final List<Item> items;
    private Customer customer;
    private final List<Receiver> receivers = new ArrayList<>();

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
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id='").append(id).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", ownId='").append(ownId).append('\'');
        sb.append(", items=").append(items);
        sb.append(", customer=").append(customer);
        sb.append(", receivers=").append(receivers);
        sb.append('}');
        return sb.toString();
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
            final StringBuilder sb = new StringBuilder("Item{");
            sb.append("product='").append(product).append('\'');
            sb.append(", quantity=").append(quantity);
            sb.append(", detail='").append(detail).append('\'');
            sb.append(", price=").append(price);
            sb.append('}');
            return sb.toString();
        }
    }
}
