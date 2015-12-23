package br.com.moip.request;

public class CustomerRequest {

    private String ownId;
    private String fullname;
    private String email;
    private ApiDateRequest birthDate;
    private TaxDocumentRequest taxDocument;
    private ShippingAddressRequest shippingAddress;
    private PhoneRequest phone;

    public String getOwnId() {
        return ownId;
    }

    public CustomerRequest ownId(final String ownId) {
        this.ownId = ownId;

        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public CustomerRequest fullname(final String fullname) {
        this.fullname = fullname;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerRequest email(final String email) {
        this.email = email;

        return this;
    }

    public ApiDateRequest getBirthDate() {
        return this.birthDate;
    }

    public CustomerRequest birthdate(ApiDateRequest birthdateRequest) {
        this.birthDate = birthdateRequest;
        return this;
    }

    public CustomerRequest taxDocument(TaxDocumentRequest taxDocumentRequest) {
        this.taxDocument = taxDocumentRequest;

        return this;
    }

    public CustomerRequest shippingAddressRequest(ShippingAddressRequest shippingAddressRequest) {
        this.shippingAddress = shippingAddressRequest;

        return this;
    }

    public TaxDocumentRequest getTaxDocument() {
        return taxDocument;
    }

    public ShippingAddressRequest getShippingAddress() {
        return shippingAddress;
    }

    public PhoneRequest getPhone() {
        return phone;
    }

    public CustomerRequest phone(PhoneRequest phone) {
        this.phone = phone;

        return this;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "ownId='" + ownId + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", taxDocument=" + taxDocument +
                ", shippingAddress=" + shippingAddress +
                ", phone=" + phone +
                '}';
    }
}
