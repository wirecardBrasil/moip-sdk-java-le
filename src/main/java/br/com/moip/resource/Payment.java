package br.com.moip.resource;

public class Payment {

    private String id;
    private PaymentStatus status;
    private Amount amount;
    private int installmentCount;
    private final FundingInstrument fundingInstrument = new FundingInstrument();
    private Geolocation geolocation;
    private PaymentLinks _links = new PaymentLinks();

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

    public String getPaymentLink() {
        return _links.getSelf();
    }

    public void setPaymentLink(String links) {
        this._links.setSelf(links);
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
        sb.append(", links=").append(_links);
        sb.append('}');
        return sb.toString();
    }

}
