package br.com.moip.resource;

import java.util.Date;

public class Customer {

    private String ownId;
    private String fullname;
    private String email;
    private TaxDocument taxDocument;
    private Phone phone;
    private Date birthDate;
    private ShippingAddress shippingAddress;
    private String id;
    private FundingInstrument fundingInstrument;

    public String getOwnId() {
        return ownId;
    }

    public String getFullname() {
        return fullname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(final String email) {
        this.email = email;

        return this;
    }

    public TaxDocument getTaxDocument() {
        return taxDocument;
    }

    public Phone getPhone() {
        return phone;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public FundingInstrument getFundingInstrument() {
        return fundingInstrument;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ownId='" + ownId + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", taxDocument=" + taxDocument +
                ", phone=" + phone +
                ", birthDate=" + birthDate +
                ", shippingAddress=" + shippingAddress +
                '}';
    }

    public String getId() {
        return id;
    }

}
