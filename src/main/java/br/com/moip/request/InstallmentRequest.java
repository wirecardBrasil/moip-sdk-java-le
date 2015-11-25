package br.com.moip.request;

import java.util.Arrays;

public class InstallmentRequest {

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

    public InstallmentRequest quantity(final int[] quantity) {
        this.quantity = quantity;
        return this;
    }
}