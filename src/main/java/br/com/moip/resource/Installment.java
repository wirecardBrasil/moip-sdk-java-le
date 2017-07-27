package br.com.moip.resource;

import java.util.Arrays;

public class Installment {

    private int[] quantity;
    private int addition;
    private int discount;

    public int[] getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return new StringBuilder("Installment{")
                .append("quantity='").append(Arrays.toString(quantity))
                .append(", addition='").append(addition)
                .append(", discount='").append(discount)
                .append('}').toString();
    }

    public Installment setQuantity(int[] quantity) {
        this.quantity = quantity;
        return this;
    }

    public Installment setAddition(int addition) {
        this.addition = addition;
        return this;
    }

    public Installment setDiscount(int discount) {
        this.discount = discount;
        return this;
    }
}