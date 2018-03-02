package br.com.moip.resource;

import br.com.moip.resource.links.OrderLinks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private String id;
    private String ownId;
    private OrderStatus status;
    private String platform;
    private Date createdAt, updatedAt;
    private Amount amount;
    private final List<Item> items;
    private final List<Address> addresses = new ArrayList<>();
    private Customer customer;
    private final List<Payment> payments = new ArrayList<>();
    private final List<Escrow> escrows = new ArrayList<>();
    private final List<Refund> refunds = new ArrayList<>();
    private final List<Entry> entries = new ArrayList<>();
    private final List<Event> events = new ArrayList<>();
    private final List<Receiver> receivers = new ArrayList<>();
    private CheckoutPreferences checkoutPreferences;
    private OrderLinks _links;

    public Order() {
        items = new ArrayList<Item>();
    }

    protected Order(final Order order) {
        this.id = order.getId();
        this.amount = order.getAmount();
        this.ownId = order.getOwnId();
        this.customer = order.getCustomer();
        this.items = order.getItems();
    }

    public String getId() {
        return id;
    }

    public String getOwnId() {
        return ownId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getPlatform() { return platform; }

    public Date getCreatedAt() { return createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public Amount getAmount() {
        return amount;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Address> getAddresses() { return addresses; }

    public Customer getCustomer() {
        return customer;
    }

    public List<Payment> getPayments() { return payments; }

    public List<Escrow> getEscrows() { return escrows; }

    public List<Refund> getRefunds() { return refunds; }

    public List<Entry> getEntries() { return entries; }

    public List<Event> getEvents() { return events; }

    public List<Receiver> getReceivers() {
        return receivers;
    }

    public CheckoutPreferences getCheckoutPreferences() {
        return checkoutPreferences;
    }

    public OrderLinks getLinks() {
        return _links;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setCheckoutPreferences(CheckoutPreferences checkoutPreferences) { this.checkoutPreferences = checkoutPreferences; }

    public void setLinks(OrderLinks _links) { this._links = _links; }

    @Override
    public String toString() {
        return new StringBuilder("Order{")
                .append("id='").append(id).append('\'')
                .append(", ownId='").append(ownId).append('\'')
                .append(", status='").append(status).append('\'')
                .append(", platform='").append(platform).append('\'')
                .append(", createdAt='").append(createdAt).append('\'')
                .append(", updatedAt='").append(updatedAt).append('\'')
                .append(", amount=").append(amount)
                .append(", items=").append(items)
                .append(", addresses=").append(addresses)
                .append(", customer=").append(customer)
                .append(", payments=").append(payments)
                .append(", escrows=").append(escrows)
                .append(", refunds=").append(refunds)
                .append(", entries=").append(entries)
                .append(", events=").append(events)
                .append(", receivers=").append(receivers)
                .append(", checkoutPreferences=").append(checkoutPreferences)
                .append(", _links=").append(_links)
                .append('}').toString();
    }

    public static final class Item {
        private String product;
        private Integer quantity;
        private String detail;
        private Integer price;
        private String category;

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

        public String getCategory() { return category; }

        @Override
        public String toString() {
            return new StringBuilder("Item{")
                    .append("product='").append(product).append('\'')
                    .append(", quantity=").append(quantity)
                    .append(", detail='").append(detail).append('\'')
                    .append(", price=").append(price)
                    .append(", category='").append(category).append('\'')
                    .append('}').toString();
        }
    }
}
