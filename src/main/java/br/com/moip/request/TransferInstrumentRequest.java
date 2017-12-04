package br.com.moip.request;

public class TransferInstrumentRequest {

    private Method method;
    private BankAccountRequest bankAccount;
    private MoipAccountRequest moipAccount;

    public TransferInstrumentRequest bankAccount(BankAccountRequest bankAccount) {
        this.method = Method.BANK_ACCOUNT;
        this.bankAccount = bankAccount;

        return this;
    }

    public TransferInstrumentRequest moipAccount(MoipAccountRequest moipAccount) {
        this.method = Method.MOIP_ACCOUNT;
        this.moipAccount = moipAccount;

        return this;
    }

    public enum Method{
        BANK_ACCOUNT, MOIP_ACCOUNT;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("TransferInstrumentRequest{")
            .append("method=").append(method);
        if(method == Method.BANK_ACCOUNT)
            stringBuilder.append(", bankAccount=").append(bankAccount);

        else
            stringBuilder.append(", moipAccount=").append(moipAccount);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
