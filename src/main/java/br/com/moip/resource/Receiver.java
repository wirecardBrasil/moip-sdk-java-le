package br.com.moip.resource;

public class Receiver {

    private Amount amount;
    private Type type;
    private MoipAccount moipAccount;
    private boolean feePayor;

    public Amount getAmount() {
        return amount;
    }

    public Type getType() {
        return type;
    }

    public MoipAccount getMoipAccount() {
        return moipAccount;
    }

    public boolean getFeePayor() {
        return feePayor;
    }

    public boolean isPrimary() {
        return Type.PRIMARY == getType();
    }

    public boolean isSecondary() {
        return Type.SECONDARY == getType();
    }

    @Override
    public String toString() {
        return new StringBuilder("Receiver{")
                .append("amount=").append(amount)
                .append(", type=").append(type)
                .append(", moipAccount=").append(moipAccount)
                .append('}').toString();
    }

    public enum Type {
        PRIMARY, SECONDARY;
    }
}
