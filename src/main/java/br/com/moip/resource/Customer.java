package br.com.moip.resource;

public class Customer {

    private String ownId;
    private String fullname;
    private String email;

    public String getOwnId() {
        return ownId;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(final String email) {
        this.email = email;

        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("ownId='").append(ownId).append('\'');
        sb.append(", fullname='").append(fullname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
