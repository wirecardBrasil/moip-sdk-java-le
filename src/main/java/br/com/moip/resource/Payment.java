package br.com.moip.resource;

public class Payment {

    private String id;
    private PaymentStatus status;
    private Amount amount;
    private int installmentCount;
    private final FundingInstrument fundingInstrument = new FundingInstrument();
    private Geolocation geolocation;

    public String getId() {
        return id;
    }

    public FundingInstrument getFundingInstrument() {
        return fundingInstrument;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Amount getAmount() {
        return amount;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }
}
