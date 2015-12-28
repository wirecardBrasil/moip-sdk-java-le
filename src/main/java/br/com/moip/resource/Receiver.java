package br.com.moip.resource;

public class Receiver {

    private Amount amount;
    private Type type;
    private MoipAccount moipAccount;

    public Amount getAmount() {
        return amount;
    }

    public Type getType() {
        return type;
    }

    public MoipAccount getMoipAccount() {
        return moipAccount;
    }

    public boolean isPrimary() {
        return Type.PRIMARY == getType();
    }

    public boolean isSecondary() {
        return Type.SECONDARY == getType();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Receiver{");
        sb.append("amount=").append(amount);
        sb.append(", type=").append(type);
        sb.append(", moipAccount=").append(moipAccount);
        sb.append('}');
        return sb.toString();
    }

    public enum Type {
        PRIMARY, SECONDARY;
    }
}
