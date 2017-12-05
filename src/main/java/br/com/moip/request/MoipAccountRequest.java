package br.com.moip.request;

public class MoipAccountRequest {

    private final String id;

    public MoipAccountRequest(String moipAccount) {
        this.id = moipAccount;
    }

    public String getId() {
        return id;
    }
}
