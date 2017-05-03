package br.com.moip.resource;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPreferences {

    private FundingInstrument fundingInstruments;
    private List<Installment> installments;
    private boolean suppressShippingAddress;

    public FundingInstrument getFundingInstruments() {
        return fundingInstruments;
    }

    public CheckoutPreferences setFundingInstruments(FundingInstrument fundingInstruments) {
        this.fundingInstruments = fundingInstruments;
        return this;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public CheckoutPreferences setInstallments(List<Installment> installments) {
        this.installments = installments;
        return this;
    }

    public boolean isSuppressShippingAddress() {
        return suppressShippingAddress;
    }

    public CheckoutPreferences setSuppressShippingAddress(boolean suppressShippingAddress) {
        this.suppressShippingAddress = suppressShippingAddress;
        return this;
    }

    public CheckoutPreferences addInstallment(final Installment installment) {
        if (installments == null)
            installments = new ArrayList<Installment>();

        installments.add(installment);
        return this;
    }

    public CheckoutPreferences addInstallment(final int[] quantity) {
        if (installments == null)
            installments = new ArrayList<Installment>();

        installments.add(new Installment().setQuantity(quantity));
        return this;
    }

    @Override
    public String toString() {
        return "CheckoutPreferences{" +
                "fundingInstruments=" + fundingInstruments +
                ", installments=" + installments +
                ", suppressShippingAddress=" + suppressShippingAddress +
                '}';
    }
}