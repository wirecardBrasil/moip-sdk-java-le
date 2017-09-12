package br.com.moip.request;

public class OrderAmountRequest {
	
	private String currency;
	private SubtotalsRequest subtotals;
	
	public String getCurrency() {
		return currency;
	}
	
	public OrderAmountRequest currency(String currency) {
		this.currency = currency;
		
		return this;
	}
	
	public SubtotalsRequest getSubtotals() {
		return subtotals;
	}
	
	public OrderAmountRequest subtotals(SubtotalsRequest subtotals) {
		this.subtotals = subtotals;
		
		return this;
	}
	
	@Override
    public String toString() {
        return new StringBuilder("OrderAmountRequest{")
                .append(", currency=").append(currency)
                .append(", subtotals=").append(subtotals)
                .append('}').toString();
    }

}
