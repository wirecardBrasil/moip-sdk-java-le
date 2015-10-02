package br.com.moip.resource.structure;

public class Subtotals {
    private Integer shipping;
    private Integer adition;
    private Integer discount;
    private Integer items;

    public Integer getShipping() {
        return shipping;
    }

    public Integer getAdition() {
        return adition;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Integer getItems() {
        return items;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public void setAdition(Integer adition) {
        this.adition = adition;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Subtotals{" +
                "shipping=" + shipping +
                ", adition=" + adition +
                ", discount=" + discount +
                ", items=" + items +
                '}';
    }
}