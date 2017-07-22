package br.com.moip.request;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {

    private String ownId;
    private OrderAmountRequest amount;
    private final List<ItemRequest> items = new ArrayList<ItemRequest>();
    private CustomerRequest customer;
    private final List<ReceiverRequest> receivers = new ArrayList<ReceiverRequest>();

    public String getOwnId() {
        return ownId;
    }

    public OrderRequest ownId(final String ownId) {
        this.ownId = ownId;

        return this;
    }
    
    public OrderAmountRequest getAmount() {
		return amount;
	}
    
    public OrderRequest amount(OrderAmountRequest amount) {
    	this.amount = amount;
    	
		return this;
	}

    public List<ItemRequest> getItems() {
        return items;
    }

    public OrderRequest addItem(final String product, final Integer quantity, final String detail, final Integer price) {
        items.add(new ItemRequest(product, quantity, detail, price));

        return this;
    }

    public List<ReceiverRequest> getReceivers() {
        return receivers;
    }

    public OrderRequest addReceiver(final ReceiverRequest receiverRequest) {
        receivers.add(receiverRequest);

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
        return new StringBuilder("OrderRequest{")
                .append("ownId='").append(ownId).append('\'')
                .append(", items=").append(items)
                .append(", customer=").append(customer)
                .append('}').toString();
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
            return new StringBuilder("Item{")
                    .append("product='").append(product).append('\'')
                    .append(", quantity=").append(quantity)
                    .append(", detail='").append(detail).append('\'')
                    .append(", price=").append(price)
                    .append('}').toString();
        }
    }

}
