package br.com.moip.resource;

public class MoipAccount {

    private String id;
    private String fullname;
    private String login;
    private String email;
    private String account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() { return account; }

    @Override
    public String toString() {
        return new StringBuilder("MoipAccount{")
                .append("id='").append(id).append('\'')
                .append(", email='").append(email).append('\'')
                .append(", fullname='").append(fullname).append('\'')
                .append(", login='").append(login).append('\'')
                .append('}').toString();
    }
}
