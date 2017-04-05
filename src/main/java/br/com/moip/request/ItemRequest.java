package br.com.moip.request;

public class ItemRequest {

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
        final StringBuffer sb = new StringBuffer("ItemRequest{");
        sb.append("product='").append(product).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", detail='").append(detail).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
