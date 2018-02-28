package br.com.moip.resource;

import java.util.List;

public class Balances {

    private List<Balance> unavailable;
    private List<Balance> future;
    private List<Balance> current;

    public Balance getUnavailable() { return unavailable.get(0); }

    public Balance getFuture() { return future.get(0); }

    public Balance getCurrent() { return current.get(0); }

    public class Balance {

        public int amount;
        public String currency;

        public int getAmount() { return amount; }

        public String getCurrency() { return currency; }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append('{')
                    .append("amount=").append(amount)
                    .append(",currency=").append(currency)
                    .append('}').toString();
        }
    }

    @Override
    public String toString() {
        return new StringBuilder("Balances{")
                .append("unavailable=").append(unavailable)
                .append("future").append(future)
                .append("current").append(current)
                .append('}').toString();
    }
}
