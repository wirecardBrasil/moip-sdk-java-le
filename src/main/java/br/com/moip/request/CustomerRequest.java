package br.com.moip.request;

import java.util.ArrayList;
import java.util.List;

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
    private List<FundingInstrumentRequest> fundingInstruments;

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

    @Deprecated
    public CustomerRequest fundingInstrument(FundingInstrumentRequest fundingInstrument) {
        this.fundingInstrument = fundingInstrument;
        return this;
    }

    @Deprecated
    public FundingInstrumentRequest getFundingInstrument() {
        return fundingInstrument;
    }

    public String getId() {
        return id;
    }

    public CustomerRequest id(String id) {
        this.id = id;
        return this;
    }

    public List<FundingInstrumentRequest> getFundingInstruments() {
        return fundingInstruments;
    }

    public CustomerRequest setFundingInstruments(List<FundingInstrumentRequest> fundingInstruments) {
        this.fundingInstruments = fundingInstruments;
        return this;
    }

    public CustomerRequest addFundingInstrument(FundingInstrumentRequest fundingInstrument) {
        if(fundingInstruments == null)
            fundingInstruments = new ArrayList<>();
        fundingInstruments.add(fundingInstrument);

        return this;
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
        sb.append(", fundingInstruments=").append(fundingInstruments);
        sb.append('}');
        return sb.toString();
    }
}