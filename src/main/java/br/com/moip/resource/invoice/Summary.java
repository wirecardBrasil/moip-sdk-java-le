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
        final StringBuilder sb = new StringBuilder("Summary{");
        sb.append("count=").append(count);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}