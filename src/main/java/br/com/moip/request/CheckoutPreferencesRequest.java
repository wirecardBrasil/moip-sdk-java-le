package br.com.moip.request;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPreferencesRequest {

    private FundingInstrumentRequest fundingInstruments;
    private List<InstallmentRequest> installments;
    private boolean supressShippingAddress;

    public FundingInstrumentRequest getFundingInstruments() {
        return fundingInstruments;
    }

    public CheckoutPreferencesRequest fundingInstruments(final FundingInstrumentRequest fundingInstruments) {
        this.fundingInstruments = fundingInstruments;
        return this;
    }

    public List<InstallmentRequest> getInstallments() {
        return installments;
    }

    public CheckoutPreferencesRequest installments(final List<InstallmentRequest> installments) {
        this.installments = installments;
        return this;
    }

    public boolean isSupressShippingAddress() {
        return supressShippingAddress;
    }

    public CheckoutPreferencesRequest supressShippingAddress(final boolean supressShippingAddress) {
        this.supressShippingAddress = supressShippingAddress;
        return this;
    }

    public CheckoutPreferencesRequest addInstallment(final InstallmentRequest installment) {
        if (installments == null)
            installments = new ArrayList<InstallmentRequest>();

        installments.add(installment);
        return this;
    }

    public CheckoutPreferencesRequest addInstallment(final int[] quantity) {
        if (installments == null)
            installments = new ArrayList<InstallmentRequest>();

        installments.add(new InstallmentRequest().quantity(quantity));
        return this;
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