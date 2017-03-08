package br.com.moip.request;

public class CustomerRequest {

    private String id;
    private String ownId;
    private String fullname;
    private String email;
    private ApiDateRequest birthDate;
    private TaxDocumentRequest taxDocument;
    private ShippingAddressRequest shippingAddress;
    private PhoneRequest phone;
    private FundingInstrumentRequest fundingInstrument;

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


    public CustomerRequest fundingInstrument(FundingInstrumentRequest fundingInstrument) {
        this.fundingInstrument = fundingInstrument;
        return this;
    }

    public FundingInstrumentRequest getFundingInstrument() {
        return fundingInstrument;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerRequest{");
        sb.append("id='").append(id).append('\'');
        sb.append(", ownId='").append(ownId).append('\'');
        sb.append(", fullname='").append(fullname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", taxDocument=").append(taxDocument);
        sb.append(", shippingAddress=").append(shippingAddress);
        sb.append(", phone=").append(phone);
        sb.append(", fundingInstrument=").append(fundingInstrument);
        sb.append('}');
        return sb.toString();
    }
}