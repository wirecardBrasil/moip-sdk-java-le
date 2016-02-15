package br.com.moip.resource;

public class MoipAccount {

    private String id;
    private String fullname;
    private String login;
    private String email;

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
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
