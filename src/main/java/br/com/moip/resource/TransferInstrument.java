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

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("TransferInstrument{");
        sb.append("method=").append(method);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", moipAccount=").append(moipAccount);
        sb.append('}');
        return sb.toString();

    }

    public enum Method {
        BANK_ACCOUNT, MOIP_ACCOUNT;
    }
}
