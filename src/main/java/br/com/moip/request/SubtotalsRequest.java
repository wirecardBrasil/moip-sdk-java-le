package br.com.moip.request;

public class SubtotalsRequest {
	
	private Integer shipping;
	private Integer addition;
	private Integer discount;
	
	public Integer getShipping() {
		return shipping;
	}
	
	public SubtotalsRequest shipping(Integer shipping) {
		this.shipping = shipping;
		
		return this;
	}
	
	public Integer getaddition() {
		return addition;
	}
	
	public SubtotalsRequest addition(Integer addition) {
		this.addition = addition;
		
		return this;
	}
	
	public Integer getDiscount() {
		return discount;
	}
	
	public SubtotalsRequest discount(Integer discount) {
		this.discount = discount;
		
		return this;
	}
	
	@Override
    public String toString() {
        return new StringBuilder("SubtotalsRequest{")
                .append(", shipping=").append(shipping)
                .append(", addition=").append(addition)
                .append(", discount=").append(discount)
                .append('}').toString();
    }

}
