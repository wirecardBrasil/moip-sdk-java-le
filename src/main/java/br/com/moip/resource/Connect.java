package br.com.moip.resource;

public class Connect {

    private String accessToken;
    private ApiDate expires_in;
    private String scope;
    private MoipAccount moipAccount;
    private String refreshToken;

    public ApiDate getExpiresIn() {
        return expires_in;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getScope() {
        return scope;
    }

    public MoipAccount getMoipAccount() {
        return moipAccount;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Connect{");
        sb.append("accessToken='").append(accessToken).append('\'');
        sb.append(", expiresIn='").append(expires_in);
        sb.append(", scope='").append(scope).append('\'');
        sb.append(", refreshToken='").append(refreshToken).append('\'');
        sb.append(", moipAccount='").append(moipAccount);
        sb.append('}');
        return sb.toString();
    }
}
