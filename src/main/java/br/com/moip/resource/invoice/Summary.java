package br.com.moip.resource.invoice;

public class Summary {

    private int count;
    private long amount;

    public int getCount() {
        return count;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return new StringBuilder("Summary{")
                .append("count=").append(count)
                .append(", amount=").append(amount)
                .append('}').toString();
    }
}