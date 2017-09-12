package br.com.moip.request;

public class SubtotalsRequest {
	
	private Integer shipping;
	private Integer addiction;
	private Integer discount;
	
	public Integer getShipping() {
		return shipping;
	}
	
	public SubtotalsRequest shipping(Integer shipping) {
		this.shipping = shipping;
		
		return this;
	}
	
	public Integer getAddiction() {
		return addiction;
	}
	
	public SubtotalsRequest addiction(Integer addiction) {
		this.addiction = addiction;
		
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
                .append(", addiction=").append(addiction)
                .append(", discount=").append(discount)
                .append('}').toString();
    }

}
