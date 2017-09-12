package br.com.moip.resource;

public class IdentityDocument {

    private Type type;
    private String number;
    private String issuer;
    private ApiDate issueDate;

    public String getNumber() {
        return number;
    }

    public String getIssuer() {
        return issuer;
    }

    public ApiDate getIssueDate() {
        return issueDate;
    }

    public Type getType() {
        return type;
    }

    private enum Type {
        RG
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IdentityDocument{");
        sb.append("type='").append(type).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append("}");
        return sb.toString();
    }
}
