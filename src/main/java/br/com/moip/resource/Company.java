package br.com.moip.resource;

public class Company {

    private String name;
    private String businessName;
    private TaxDocument taxDocument;
    private ApiDate openingDate;
    private Phone phone;
    private ShippingAddress address;

    public String getName() {
        return name;
    }

    public String getBusinessName() {
        return businessName;
    }

    public ApiDate getOpeningDate() {
        return openingDate;
    }

    public Phone getPhone() {
        return phone;
    }

    public ShippingAddress getAddress() {
        return address;
    }

    public TaxDocument getTaxDocument() {
        return taxDocument;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", businessName='").append(businessName).append('\'');
        sb.append(", taxDocument=").append(taxDocument);
        sb.append(", openingDate=").append(openingDate);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
