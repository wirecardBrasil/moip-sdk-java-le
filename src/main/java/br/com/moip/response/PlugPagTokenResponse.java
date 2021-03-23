package br.com.moip.response;

public class PlugPagTokenResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "PlugPagTokenResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
