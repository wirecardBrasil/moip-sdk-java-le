package br.com.moip.resource;

import br.com.moip.resource.links.AccountLinks;

public class Account {

    private String id;
    private String accessToken;
    private boolean transparentAccount;
    private Email email;
    private Person person;
    private String softDescriptor;
    private String login;
    private Company company;
    private BusinessSegment businessSegment;
    private String site;
    private Type type;
    private AccountLinks _links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessToken() { return accessToken; }

    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    public boolean isTransparentAccount() {
        return transparentAccount;
    }

    public void setTransparentAccount(boolean transparentAccount) {
        this.transparentAccount = transparentAccount;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getSoftDescriptor() {
        return softDescriptor;
    }

    public void setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public BusinessSegment getBusinessSegment() {
        return businessSegment;
    }

    public void setBusinessSegment(BusinessSegment businessSegment) {
        this.businessSegment = businessSegment;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public AccountLinks getLinks() { return _links; }

    public void setLinks(AccountLinks links) { this._links = links; }

    public class Email {
        private boolean confirmed;
        private String address;

        public boolean isConfirmed() {
            return confirmed;
        }

        public void setConfirmed(boolean confirmed) {
            this.confirmed = confirmed;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Email{");
            sb.append("confirmed=").append(confirmed);
            sb.append(", address='").append(address).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public class BusinessSegment {
        private String id;

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("BusinessSegment");
            sb.append("id='").append(id).append('\'');
            sb.append("}");
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id='").append(id).append('\'');
        sb.append(", accessToken='").append(accessToken).append('\'');
        sb.append(", type=").append(type);
        sb.append(", transparentAccount=").append(transparentAccount);
        sb.append(", email=").append(email);
        sb.append(", person=").append(person);
        sb.append(", company=").append(company);
        sb.append(", businessSegment=").append(businessSegment);
        sb.append(", softDescriptor='").append(softDescriptor).append('\'');
        sb.append(", site='").append(site).append('\'');
        sb.append(", _links=").append(_links).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public enum Type {
        MERCHANT, CONSUMER
    }
}
