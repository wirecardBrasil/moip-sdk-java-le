package br.com.moip.resource;

public class RefundingInstrument {

    private Method method;
    private BankAccount bankAccount;
    private CreditCard creditCard;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public enum Method {
        CREDIT_CARD, BANK_ACCOUNT, MOIP_ACCOUNT
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RefundingInstrument{");
        sb.append("method=").append(method);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", creditCard=").append(creditCard);
        sb.append('}');
        return sb.toString();
    }

}
