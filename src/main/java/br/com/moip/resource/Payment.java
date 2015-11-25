package br.com.moip.resource;

public class Payment {

    private String id;
    private int installmentCount;
    private FundingInstrument fundingInstrument = new FundingInstrument();

    public String getId() {
        return id;
    }

    public FundingInstrument getFundingInstrument() {
        return fundingInstrument;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }
}
