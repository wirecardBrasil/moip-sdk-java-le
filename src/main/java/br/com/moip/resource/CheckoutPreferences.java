package br.com.moip.resource;

import br.com.moip.request.CheckoutPreferencesRequest;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPreferences {

    private FundingInstrument fundingInstruments;
    private List<Installment> installments;
    private boolean suppressShippingAddress;
    private RedirectUrls redirectUrls;

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

    public RedirectUrls getRedirectUrls() {
        return redirectUrls;
    }

    public CheckoutPreferences setRedirectUrls(RedirectUrls redirectUrls) {
        this.redirectUrls = redirectUrls;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder("CheckoutPreferences{")
                .append("fundingInstruments=").append(fundingInstruments)
                .append(", installments=").append(installments)
                .append(", supressShippingAddress=").append(suppressShippingAddress)
                .append(", redirectUrls=").append(redirectUrls)
                .append("}").toString();
    }

    public static final class RedirectUrls {
        private String urlSuccess;
        private String urlFailure;

        public String getUrlSuccess() {
            return urlSuccess;
        }

        public String getUrlFailure() {
            return urlFailure;
        }

        @Override
        public String toString() {
            return new StringBuilder("RedirectUrls{")
                    .append("urlSuccess='").append(urlSuccess).append('\'')
                    .append(", urlFailure='").append(urlFailure).append('\'')
                    .append('}').toString();
        }
    }
}