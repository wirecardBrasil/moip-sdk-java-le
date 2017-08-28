package br.com.moip.resource;

import br.com.moip.resource.links.MultipaymentLinks;

import java.util.ArrayList;
import java.util.List;

public class Multipayment {

    private String id;
    private PaymentStatus status;
    private Amount amount;
    private int installmentCount;
    private final FundingInstrument fundingInstrument = new FundingInstrument();
    private final List<Payment> payments = new ArrayList<Payment>();
    private Boolean delayCapture;
    private MultipaymentLinks _links;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;
    }

    public FundingInstrument getFundingInstrument() {
        return fundingInstrument;
    }

    public void setDelayCapture(Boolean delayCapture) {
        this.delayCapture = delayCapture;
    }

    public Boolean getDelayCapture() {
        return delayCapture;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public MultipaymentLinks getLinks() {
        return _links;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Multipayment{");
        sb.append("id='").append(id).append('\'');
        sb.append(", status=").append(status);
        sb.append(", amount=").append(amount);
        sb.append(", installmentCount=").append(installmentCount);
        sb.append(", fundingInstrument=").append(fundingInstrument);
        sb.append(", payments=").append(payments);
        sb.append(", links=").append(_links);
        sb.append('}');
        return sb.toString();
    }
}
