package br.com.moip.request;

import java.util.ArrayList;
import java.util.List;

public class PersonRequest {

    private String name;
    private String lastName;
    private TaxDocumentRequest taxDocument;
    private IdentityDocumentRequest identityDocument;
    private ApiDateRequest birthDate;
    private String nationality;
    private String birthPlace;
    private ParentsNameRequest parentsName;
    private PhoneRequest phone;
    private List<PhoneRequest> alternativePhones = new ArrayList<PhoneRequest>();
    private ShippingAddressRequest address;


    public PersonRequest name(String name) {
        this.name = name;

        return this;
    }

    public PersonRequest lastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public PersonRequest taxDocument(TaxDocumentRequest taxDocument) {
        this.taxDocument = taxDocument;

        return this;
    }

    public PersonRequest identityDocument(IdentityDocumentRequest identityDocument) {
        this.identityDocument = identityDocument;

        return this;
    }

    public PersonRequest birthDate(ApiDateRequest birthDate) {
        this.birthDate = birthDate;

        return this;
    }

    public PersonRequest birthPlace(String birthPlace) {
        this.birthPlace = birthPlace;

        return this;
    }

    public PersonRequest nationality(String nationality) {
        this.nationality = nationality;

        return this;
    }

    public PersonRequest parentsName(ParentsNameRequest parentsName) {
        this.parentsName = parentsName;

        return this;
    }

    public PersonRequest phone(PhoneRequest phone) {
        this.phone = phone;

        return this;
    }

    public PersonRequest addAlternativePhone(final PhoneRequest phone) {
        alternativePhones.add(phone);

        return this;
    }

    public PersonRequest address(ShippingAddressRequest address) {
        this.address = address;

        return this;
    }

    public static class ParentsNameRequest {
        private String mother;
        private String father;

        public ParentsNameRequest() {

        }

        public ParentsNameRequest(String mother, String father) {
            this.mother = mother;
            this.father = father;
        }

        public ParentsNameRequest mother(String mother) {
            this.mother = mother;

            return this;
        }

        public ParentsNameRequest father(String father) {
            this.father = father;

            return this;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", lastName=").append(lastName).append('\'');
        sb.append(", taxDocument=").append(taxDocument);
        sb.append(", identityDocument=").append(identityDocument);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", nationality=").append(nationality).append('\'');
        sb.append(", birthPlace=").append(birthPlace).append('\'');
        sb.append(", parentsName=").append(parentsName);
        sb.append(", phone=").append(phone);
        sb.append(", alternativePhones=").append(phone);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
