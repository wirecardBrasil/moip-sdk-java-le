package br.com.moip.resource;

public class Amount {

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Amount{");
        sb.append("total=").append(total);
        sb.append('}');
        return sb.toString();
    }
}
