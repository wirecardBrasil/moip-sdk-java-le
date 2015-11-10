package br.com.moip.resource;

public class Payment {

    private String id;
    private FundingInstrument fundingInstrument = new FundingInstrument();
    private int installmentCount;

    public String getId() {
        return id;
    }

    public FundingInstrument getFundingInstrument() {
        return fundingInstrument;
    }

    public Payment setFundingInstrument(FundingInstrument fundingInstrument) {
        this.fundingInstrument = fundingInstrument;

        return this;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public Payment setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;

        return this;
    }
}
