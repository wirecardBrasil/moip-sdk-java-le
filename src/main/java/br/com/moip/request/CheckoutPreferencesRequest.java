package br.com.moip.request;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPreferencesRequest {

    private FundingInstrumentRequest fundingInstruments;
    private List<InstallmentRequest> installments;
    private RedirectUrlsRequest redirectUrls;
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

    public RedirectUrlsRequest getRedirectUrls() {
        return redirectUrls;
    }

    public CheckoutPreferencesRequest setRedirectUrls(RedirectUrlsRequest redirectUrls) {
        this.redirectUrls = redirectUrls;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder("CheckoutPreferences{")
                .append("fundingInstruments=").append(fundingInstruments)
                .append(", installments=").append(installments)
                .append(", supressShippingAddress=").append(supressShippingAddress)
                .append(", redirectUrls").append(redirectUrls)
                .append('}').toString();
    }

    public static final class RedirectUrlsRequest {
        private String urlSuccess;
        private String urlFailure;

        public RedirectUrlsRequest(String urlSuccess, String urlFailure) {
            this.urlSuccess = urlSuccess;
            this.urlFailure = urlFailure;
        }

        public String getUrlSuccess() {
            return urlSuccess;
        }

        public void setUrlSuccess(String urlSuccess) {
            this.urlSuccess = urlSuccess;
        }

        public String getUrlFailure() {
            return urlFailure;
        }

        public void setUrlFailure(String urlFailure) {
            this.urlFailure = urlFailure;
        }

        @Override
        public String toString() {
            return new StringBuilder("RedirectUrlsRequest{")
                    .append("urlSuccess='").append(urlSuccess).append('\'')
                    .append(", urlFailure='").append(urlFailure).append('\'')
                    .append('}').toString();
        }
    }
}