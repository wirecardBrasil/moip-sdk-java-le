package br.com.moip.request;

public class HolderRequest {

    private String fullname;
    private String birthdate;
    private PhoneRequest phone;
    private TaxDocumentRequest taxDocument;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HolderRequest{");
        sb.append("fullname='").append(fullname).append('\'');
        sb.append(", birthdate='").append(birthdate).append('\'');
        sb.append(", phone=").append(phone);
        sb.append(", taxDocument=").append(taxDocument);
        sb.append('}');
        return sb.toString();
    }
}
