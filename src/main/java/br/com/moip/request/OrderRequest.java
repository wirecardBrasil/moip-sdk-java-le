package br.com.moip.request;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {

    private String ownId;
    private final List<ItemRequest> items = new ArrayList<ItemRequest>();
    private CustomerRequest customer;

    public String getOwnId() {
        return ownId;
    }

    public OrderRequest ownId(final String ownId) {
        this.ownId = ownId;

        return this;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public OrderRequest addItem(final String product, final Integer quantity, final String detail, final Integer price) {
        items.add(new ItemRequest(product, quantity, detail, price));

        return this;
    }

    public CustomerRequest getCustomer() {
        return customer;
    }

    public OrderRequest customer(final CustomerRequest customer) {
        this.customer = customer;

        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderRequest{");
        sb.append("ownId='").append(ownId).append('\'');
        sb.append(", items=").append(items);
        sb.append(", customer=").append(customer);
        sb.append('}');
        return sb.toString();
    }

    public static final class ItemRequest {
        private final String product;
        private final Integer quantity;
        private final String detail;
        private final Integer price;

        public ItemRequest(String product, Integer quantity, String detail, Integer price) {
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
