package br.com.moip.resource;

import java.util.Arrays;

public class Installment {

    private int[] quantity;

    public Installment() {
    }

    public Installment(int[] quantity) {
        this.quantity = quantity;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "quantity=" + Arrays.toString(quantity) +
                '}';
    }
}