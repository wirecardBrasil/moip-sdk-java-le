package br.com.moip.resource;

public class Amount {

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return new StringBuilder("Amount{")
                .append("total=").append(total)
                .append('}').toString();
    }
}
