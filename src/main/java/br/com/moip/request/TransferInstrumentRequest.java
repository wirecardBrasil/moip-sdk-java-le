package br.com.moip.request;

import br.com.moip.resource.BankAccount;

public class TransferInstrumentRequest {

    private Method method;
    private BankAccountRequest bankAccount;

    public TransferInstrumentRequest bankAccount(BankAccountRequest bankAccount){
        this.method = Method.BANK_ACCOUNT;
        this.bankAccount = bankAccount;

        return this;
    }

    public TransferInstrumentRequest moipAccount(){
        this.method = Method.MOIP_ACCOUNT;

        return this;
    }

    public enum Method{
        BANK_ACCOUNT, MOIP_ACCOUNT;
    }

    @Override
    public String toString(){
        return new StringBuilder("TransferInstrumentRequest{")
                .append("method=").append(method)
                .append(", bankAccount=").append(bankAccount)
                .append("}").toString();
    }
}
