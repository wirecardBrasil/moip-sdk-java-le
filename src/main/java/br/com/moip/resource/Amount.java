package br.com.moip.resource;

public class Amount {

    private Integer paid;
    private Integer total;
    private Integer fees;
    private Integer refunds;
    private Integer liquid;
    private Integer otherReceivers;
    private String currency;
    private Subtotals subtotals;

    public Integer getPaid() { return paid; }

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

    public Integer getOtherReceivers() { return otherReceivers; }

    public String getCurrency() {
        return currency;
    }

    public Subtotals getSubtotals() { return subtotals; }

    @Override
    public String toString() {
        return new StringBuilder("Amount{")
                .append("total=").append(total)
                .append(", fees=").append(fees)
                .append(", refunds=").append(refunds)
                .append(", liquid=").append(liquid)
                .append(", currency='").append(currency)
                .append('\'')
                .append('}').toString();
    }

    public class Subtotals {

        private Integer shipping;
        private Integer addition;
        private Integer discount;
        private Integer items;

        public Integer getShipping() { return shipping; }

        public Integer getAddition() { return addition; }

        public Integer getDiscount() { return discount; }

        public Integer getItems() { return items; }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append('{')
                    .append("shipping=").append(shipping)
                    .append(", addition=").append(addition)
                    .append(", discount=").append(discount)
                    .append(", items=").append(items)
                    .append('}').toString();
        }
    }
}
