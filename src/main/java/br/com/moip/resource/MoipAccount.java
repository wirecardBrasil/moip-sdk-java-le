package br.com.moip.resource;

public class MoipAccount {

    private String id;
    private String fullname;
    private String login;
    private String email;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MoipAccount{");
        sb.append("id='").append(id).append('\'');
        sb.append("email='").append(email).append('\'');
        sb.append(", fullname='").append(fullname).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
