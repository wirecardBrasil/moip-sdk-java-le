package br.com.moip.request;

import java.util.ArrayList;
import java.util.List;

public class MultiorderRequest {

    private String ownId;
    private List<OrderRequest> orders = new ArrayList<>();

    public MultiorderRequest ownId(String ownId) {
        this.ownId = ownId;

        return this;
    }

    public String getOwnId() {
        return ownId;
    }

    public MultiorderRequest addOrder(OrderRequest order) {
        orders.add(order);

        return this;
    }

    public List<OrderRequest> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return new StringBuilder("MultiorderRequest {")
            .append("ownId='").append(ownId).append('\'')
            .append(", orders=").append(orders)
            .append("}").toString();
    }
}
