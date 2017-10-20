package br.com.moip.resource;

public class Amount {

    private Integer total;
    private Integer fees;
    private Integer refunds;
    private Integer liquid;
    private String currency;

    public Integer getTotal() {
        return total;
    }

    public Integer getFees() {
        return fees;
    }

    public Integer getRefunds() {
        return refunds;
    }

    public Integer getLiquid() {
        return liquid;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return new StringBuilder("Amount{")
                .append("total=").append(total)
                .append('}').toString();
    }
}
