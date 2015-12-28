package br.com.moip.request;

public class AmountRequest {
    private Integer fixed;
    private Integer percentual;

    public AmountRequest fixed(final Integer value) {
        this.fixed = value;

        return this;
    }

    public AmountRequest percentual(final Integer value) {
        this.percentual = value;

        return this;
    }

    public Integer getValue() {
        return fixed != null ? fixed : percentual;
    }
}

