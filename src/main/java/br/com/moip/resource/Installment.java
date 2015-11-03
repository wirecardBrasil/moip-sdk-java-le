package br.com.moip.resource;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Installment {

    private int[] quantity;

    public int[] getQuantity() {
        return quantity;
    }

    public Installment setQuantity(int[] quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "quantity=" + Arrays.toString(quantity) +
                '}';
    }
}