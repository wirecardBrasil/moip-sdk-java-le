package br.com.moip.resource.structure;

public class Item {
    private String product;
    private Integer quantity;
    private String detail;
    private Integer price;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                '}';
    }
}