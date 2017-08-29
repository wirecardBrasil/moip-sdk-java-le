package br.com.moip.resource;

public class RefundingInstrument {

    private Method method;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public enum Method {
        CREDIT_CARD, BANK_ACCOUNT, MOIP_ACCOUNT
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FundingInstrument{");
        sb.append(", method=").append(method);
        sb.append('}');
        return sb.toString();
    }

}
