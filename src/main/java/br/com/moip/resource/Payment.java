package br.com.moip.resource;

public class Payment {

    private String id;
    private FundingInstrument fundingInstrument = new FundingInstrument();
    private Holder holder;

    public String getId() {
        return id;
    }

    public Payment setHolder(final Holder holder) {
        this.holder = holder;

        return this;
    }

    public FundingInstrument getFundingInstrument() {
        return fundingInstrument;
    }

    public Payment setFundingInstrument(FundingInstrument fundingInstrument) {
        this.fundingInstrument = fundingInstrument;

        return this;
    }
}
