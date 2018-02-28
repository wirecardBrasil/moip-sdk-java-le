package br.com.moip.resource;

public class Fees {

    private int amount;
    private String type;

    public int getAmount() { return amount; }

    public String getType() { return type; }

    @Override
    public String toString() {
        return new StringBuilder("Fees{")
                .append("amount=").append(amount)
                .append(", type").append(type)
                .append('}').toString();
    }
}
