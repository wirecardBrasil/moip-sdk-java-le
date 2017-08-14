package br.com.moip.resource;

import java.util.List;

public class Payment {

    private String id;
    private PaymentStatus status;
    private Amount amount;
    private int installmentCount;
    private final FundingInstrument fundingInstrument = new FundingInstrument();
    private Geolocation geolocation;
    private Boolean delayCapture;
    private List<Escrow> escrows;

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

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public Boolean getDelayCapture() {
        return delayCapture;
    }

    public void setDelayCapture(Boolean delayCapture) {
        this.delayCapture = delayCapture;
    }

    public List<Escrow>getEscrows() {
        return escrows;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Payment{");
        sb.append("id='").append(id).append('\'');
        sb.append(", status=").append(status);
        sb.append(", amount=").append(amount);
        sb.append(", installmentCount=").append(installmentCount);
        sb.append(", fundingInstrument=").append(fundingInstrument);
        sb.append(", geolocation=").append(geolocation);
        sb.append(", delayCapture=").append(delayCapture);
        sb.append(", escrows=").append(escrows);
        sb.append('}');
        return sb.toString();
    }
}
