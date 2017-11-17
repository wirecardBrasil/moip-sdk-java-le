package br.com.moip.resource;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String lastName;
    private TaxDocument taxDocument;
    private IdentityDocument identityDocument;
    private ApiDate birthDate;
    private String nationality;
    private String birthPlace;
    private ParentsName parentsName;
    private Phone phone;
    private List<Phone> alternativePhones = new ArrayList<Phone>();
    private ShippingAddress address;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public ParentsName getParentsName() {
        return parentsName;
    }

    public Phone getPhone() {
        return phone;
    }

    public List<Phone> getAlternativePhones() {
        return alternativePhones;
    }

    public ShippingAddress getAddress() {
        return address;
    }

    public ApiDate getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public TaxDocument getTaxDocument() {
        return taxDocument;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", taxDocument=").append(taxDocument);
        sb.append(", identityDocument=").append(identityDocument);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", nationality='").append(nationality).append('\'');
        sb.append(", birthPlace='").append(birthPlace).append('\'');
        sb.append(", parentsName=").append(parentsName);
        sb.append(", phone=").append(phone);
        sb.append(", alternativePhones=").append(alternativePhones);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }

    public class ParentsName {
        private String mother;
        private String father;

        public String getMother() {
            return mother;
        }

        public String getFather() {
            return father;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ParentsName{");
            sb.append("mother='").append(mother).append('\'');
            sb.append(", father='").append(father).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

}
