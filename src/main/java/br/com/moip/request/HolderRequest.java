package br.com.moip.request;

public class HolderRequest {

    private String fullname;
    private String birthdate;
    private PhoneRequest phone;
    private TaxDocumentRequest taxDocument;
    private AddressRequest billingAddressRequest;

    public String getFullname() {
        return fullname;
    }

    public HolderRequest fullname(final String fullname) {
        this.fullname = fullname;

        return this;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public HolderRequest birthdate(final String birthdate) {
        this.birthdate = birthdate;

        return this;
    }

    public PhoneRequest getPhone() {
        return phone;
    }

    public HolderRequest phone(final PhoneRequest phone) {
        this.phone = phone;

        return this;
    }

    public TaxDocumentRequest getTaxDocument() {
        return taxDocument;
    }

    public HolderRequest taxDocument(final TaxDocumentRequest taxDocument) {
        this.taxDocument = taxDocument;

        return this;
    }

    public AddressRequest getBillingAddress() { return billingAddressRequest; }

    public HolderRequest billingAddress(AddressRequest billingAddressRequest) {
        this.billingAddressRequest = billingAddressRequest;

        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder("HolderRequest{")
                .append("fullname='").append(fullname).append('\'')
                .append(", birthdate='").append(birthdate).append('\'')
                .append(", phone=").append(phone)
                .append(", taxDocument=").append(taxDocument)
                .append('}').toString();
    }
}
