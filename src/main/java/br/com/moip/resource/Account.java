package br.com.moip.resource;

public class Account {

    private String id;
    private boolean transparentAccount;
    private Email email;
    private String softDescriptor;
    private String login;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public class Email{
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id='").append(id).append('\'');
        sb.append(", transparentAccount=").append(transparentAccount);
        sb.append(", email=").append(email);
        sb.append(", softDescriptor='").append(softDescriptor).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
