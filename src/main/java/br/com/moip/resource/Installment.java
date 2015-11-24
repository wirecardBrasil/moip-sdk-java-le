package br.com.moip.resource;

import java.util.Arrays;

public class Installment {

    private int[] quantity;

    public int[] getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "quantity=" + Arrays.toString(quantity) +
                '}';
    }
}