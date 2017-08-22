package br.com.moip.request;

public class ConnectRequest {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private final static String grant_type = "AUTHORIZATION_CODE";

    public ConnectRequest clientId(String clientId) {
        this.client_id = clientId;

        return this;
    }

    public ConnectRequest clientSecret(String clientSecret) {
        this.client_secret = clientSecret;

        return this;
    }

    public ConnectRequest code(String code) {
        this.code = code;

        return this;
    }

    public ConnectRequest redirectUri(String redirectUri) {
        this.redirect_uri = redirectUri;

        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Connect{");
        sb.append("client_id='").append(client_id).append('\'');
        sb.append("client_secret='").append(client_secret).append('\'');
        sb.append("code='").append(code).append('\'');
        sb.append("redirect_uri='").append(redirect_uri).append('\'');
        sb.append("grant_type='").append(grant_type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
