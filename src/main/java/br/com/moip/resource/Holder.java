package br.com.moip.resource;

public class Holder {

    private String fullname;
    private String birthdate;
    private Phone phone;
    private TaxDocument taxDocument;

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
}
