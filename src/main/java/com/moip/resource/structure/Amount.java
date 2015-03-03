package com.moip.resource.structure;

public class Amount {
	private Integer fixed;
	private Integer total;
	private Integer fees;
	private Integer refunds;
	private Integer liquid;
	private Integer otherReceivers;
	private String currency = "BRL";
	private Subtotals subtotals;

	public Integer getFixed() {
		return fixed;
	}

	public void setFixed(Integer fixed) {
		this.fixed = fixed;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public Integer getRefunds() {
		return refunds;
	}

	public void setRefunds(Integer refunds) {
		this.refunds = refunds;
	}

	public Integer getLiquid() {
		return liquid;
	}

	public void setLiquid(Integer liquid) {
		this.liquid = liquid;
	}

	public Integer getOtherReceivers() {
		return otherReceivers;
	}

	public void setOtherReceivers(Integer otherReceivers) {
		this.otherReceivers = otherReceivers;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Subtotals getSubtotals() {
		if (subtotals == null) {
			subtotals = new Subtotals();
		}
		
		return subtotals;
	}

	public void setSubtotals(Subtotals subtotals) {
		this.subtotals = subtotals;
	}
}