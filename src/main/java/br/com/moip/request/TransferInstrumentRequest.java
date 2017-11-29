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
        if(method == Method.BANK_ACCOUNT)
                return new StringBuilder("TransferInstrumentRequest{")
                        .append("method=").append(method)
                        .append(", bankAccount=").append(bankAccount)
                        .append("}").toString();

        else return  new StringBuilder("TransferInstrumentRequest{")
                .append("method=").append(method)
                .append(", moipAccount=").append(moipAccount)
                .append("}").toString();
    }
}
