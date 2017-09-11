package br.com.moip.request;

import java.util.Arrays;

public class InstallmentRequest {

    private int[] quantity;
    private int addition;
    private int discount;

    public int[] getQuantity() {
        return quantity;
    }
    public int getAddition() {
        return addition;
    }
    public int getDiscount() {return discount;}

    @Override
    public String toString() {
        return new StringBuilder("Installment{")
                .append("quantity='").append(Arrays.toString(quantity))
                .append(", addition='").append(addition)
                .append(", discount='").append(discount)
                .append('}').toString();
    }

    public InstallmentRequest quantity(final int[] quantity) {
        this.quantity = quantity;
        return this;
    }

    public InstallmentRequest addition(final int addition) {
        this.addition = addition;
        return this;
    }

    public InstallmentRequest discount(final int discount) {
        this.discount = discount;
        return this;
    }
}