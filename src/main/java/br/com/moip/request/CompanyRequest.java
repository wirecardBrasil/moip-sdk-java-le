package br.com.moip.request;

public class CompanyRequest {

    private String name;
    private String businessName;
    private TaxDocumentRequest taxDocument;
    private ApiDateRequest openingDate;
    private PhoneRequest phone;
    private ShippingAddressRequest address;
    private MainActivityRequest mainActivity;

    public CompanyRequest name(String name) {
        this.name = name;

        return this;
    }

    public CompanyRequest businessName(String businessName) {
        this.businessName = businessName;

        return this;
    }

    public CompanyRequest taxDocument(TaxDocumentRequest taxDocument) {
        this.taxDocument = taxDocument;

        return this;
    }

    public CompanyRequest openingDate(ApiDateRequest openingDate) {
        this.openingDate = openingDate;

        return this;
    }

    public CompanyRequest phone(PhoneRequest phone) {
        this.phone = phone;

        return this;
    }

    public CompanyRequest address(ShippingAddressRequest address) {
        this.address = address;

        return this;
    }

    public CompanyRequest mainActivity(MainActivityRequest mainActivity) {
        this.mainActivity = mainActivity;

        return this;
    }

    public static class MainActivityRequest {
        private String cnae;
        private String description;

        public MainActivityRequest cnae(String cnae) {
            this.cnae = cnae;

            return this;
        }

        public MainActivityRequest description(String description) {
            this.description = description;

            return this;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", businessName=").append(businessName).append('\'');
        sb.append(", taxDocument=").append(taxDocument);
        sb.append(", openingDate=").append(openingDate);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", mainActivity=").append(mainActivity);
        sb.append('}');
        return sb.toString();
    }

}
