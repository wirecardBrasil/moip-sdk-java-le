package br.com.moip.resource;

import java.util.List;

public class CheckoutPreferences {

    private FundingInstrument fundingInstruments;
    private List<Installment> installments;
    private boolean supressShippingAddress;

    public CheckoutPreferences() {
    }

    public CheckoutPreferences(FundingInstrument fundingInstruments, List<Installment> installments, boolean supressShippingAddress) {
        this.fundingInstruments = fundingInstruments;
        this.installments = installments;
        this.supressShippingAddress = supressShippingAddress;
    }

    public FundingInstrument getFundingInstruments() {
        return fundingInstruments;
    }

    public void setFundingInstruments(FundingInstrument fundingInstruments) {
        this.fundingInstruments = fundingInstruments;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }

    public boolean isSupressShippingAddress() {
        return supressShippingAddress;
    }

    public void setSupressShippingAddress(boolean supressShippingAddress) {
        this.supressShippingAddress = supressShippingAddress;
    }

    @Override
    public String toString() {
        return "CheckoutPreferences{" +
                "fundingInstruments=" + fundingInstruments +
                ", installments=" + installments +
                ", supressShippingAddress=" + supressShippingAddress +
                '}';
    }
}