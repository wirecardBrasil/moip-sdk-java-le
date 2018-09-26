package br.com.moip.resource;

public class Holder {

    private String fullname;
    private String birthdate;
    private Phone phone;
    private TaxDocument taxDocument;
    private Address billingAddress;

    public String getFullname() {
        return fullname;
    }

    public Holder setFullname(final String fullname) {
        this.fullname = fullname;

        return this;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Holder setBirthdate(final String birthdate) {
        this.birthdate = birthdate;

        return this;
    }

    public Phone getPhone() {
        return phone;
    }

    public Holder setPhone(final Phone phone) {
        this.phone = phone;

        return this;
    }

    public TaxDocument getTaxDocument() {
        return taxDocument;
    }

    public Holder setTaxDocument(final TaxDocument taxDocument) {
        this.taxDocument = taxDocument;

        return this;
    }

    public Address getBillingAddress() { return billingAddress; }

    public Holder setBillingAddress(final Address billingAddress) {
        this.billingAddress = billingAddress;

        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder("Holder{")
                .append("fullname=").append(fullname)
                .append(", birthdate=").append(birthdate)
                .append(", phone=").append(phone)
                .append(", taxDocument").append(taxDocument)
                .append(", billingAddress=").append(billingAddress)
                .append("}").toString();
    }
}
