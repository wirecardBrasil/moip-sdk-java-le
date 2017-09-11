package br.com.moip.resource;

import br.com.moip.resource.links.OrderLinks;

import java.util.ArrayList;
import java.util.List;

public class Multiorder {

    private String id;
    private String ownId;
    private final List<Order> orders = new ArrayList<>();
    private OrderStatus status;
    private ApiDate createdAt;
    private ApiDate updatedAt;
    private Amount amount;
    private OrderLinks _links;

    public String getId() {
        return id;
    }

    public String getOwnId() {
        return ownId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Amount getAmount() {
        return amount;
    }

    public ApiDate getCreatedAt() {
        return createdAt;
    }

    public ApiDate getUpdatedAt() {
        return updatedAt;
    }

    public OrderLinks getLinks() {
        return _links;
    }

    @Override
    public String toString() {
        return new StringBuilder("Multiorder{")
            .append("ownId='").append(ownId).append('\'')
            .append(", orders=").append(orders)
            .append(", status=").append(status)
            .append(", createdAt=").append(createdAt)
            .append(", updatedAt=").append(updatedAt)
            .append(", amount=").append(amount)
            .append(", links=").append(_links)
            .append("}").toString();
    }
}
