package br.com.moip.resource;

public class TransferInstrument {

    private Method method;
    private BankAccount bankAccount;
    private MoipAccount moipAccount;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public MoipAccount getMoipAccount() {
        return moipAccount;
    }

    public void setMoipAccount(MoipAccount moipAccount) {
        this.moipAccount = moipAccount;
    }

    public enum Method {
        BANK_ACCOUNT, MOIP_ACCOUNT;
    }
}
