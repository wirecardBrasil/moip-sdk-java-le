package br.com.moip.request;

public class ReceiverRequest {
    private ReceiverTypeRequest type;
    private MoipAccountRequest moipAccount;
    private AmountRequest amount;

    public ReceiverRequest primary(final String moipAccount, final AmountRequest amountRequest) {
        defaultAttributes(ReceiverTypeRequest.PRIMARY, moipAccount, amountRequest);

        return this;
    }

    public ReceiverRequest secondary(final String moipAccount, final AmountRequest amountRequest) {
        defaultAttributes(ReceiverTypeRequest.SECONDARY, moipAccount, amountRequest);

        return this;
    }

    private void defaultAttributes(ReceiverTypeRequest receiverTypeRequest, String moipAccount, AmountRequest amountRequest) {
        this.type = receiverTypeRequest;
        this.moipAccount = new MoipAccountRequest(moipAccount);
        this.amount = amountRequest;
    }

    public ReceiverTypeRequest getType() {
        return type;
    }

    public MoipAccountRequest getMoipAccount() {
        return moipAccount;
    }

    public AmountRequest getAmount() {
        return amount;
    }
}

class MoipAccountRequest {
    private final String id;

    public MoipAccountRequest(String moipAccount) {
        this.id = moipAccount;
    }

    public String getId() {
        return id;
    }
}
