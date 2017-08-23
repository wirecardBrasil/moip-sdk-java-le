package br.com.moip.request;

public class IdentityDocumentRequest {

    private Type type = Type.RG;
    private String number;
    private String issuer;
    private ApiDateRequest issueDate;

    public Type getType() {
        return type;
    }

    public IdentityDocumentRequest type(final Type type) {
        this.type = type;

        return this;
    }

    public String getNumber() {
        return number;
    }

    public IdentityDocumentRequest number(final String number) {
        this.number = number;

        return this;
    }

    public IdentityDocumentRequest issuer(final String issuer) {
        this.issuer = issuer;

        return this;
    }

    public IdentityDocumentRequest issueDate(final ApiDateRequest issueDate) {
        this.issueDate = issueDate;

        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder("IdentityDocumentRequest{")
                .append("type='").append(type).append('\'')
                .append(", number='").append(number).append('\'')
                .append(", issuer='").append(issuer).append('\'')
                .append(", issueDate='").append(issueDate).append('\'')
                .append('}').toString();
    }

    public enum Type {
        RG
    }
}
