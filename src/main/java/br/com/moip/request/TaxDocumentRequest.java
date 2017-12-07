package br.com.moip.request;

public class TaxDocumentRequest {

    private Type type;
    private String number;

    private TaxDocumentRequest() {
    }

    public Type getType() {
        return type;
    }

    private TaxDocumentRequest type(final Type type) {
        this.type = type;

        return this;
    }

    public String getNumber() {
        return number;
    }

    public TaxDocumentRequest number(final String number) {
        this.number = number;

        return this;
    }

    public static TaxDocumentRequest cpf(final String number) {
        return new TaxDocumentRequest()
                .type(Type.CPF)
                .number(number);
    }

    public static TaxDocumentRequest cnpj(final String number) {
        return new TaxDocumentRequest()
                .type(Type.CNPJ)
                .number(number);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaxDocument{");
        sb.append("type=").append(type);
        sb.append(", number='").append(number).append('\'');
        sb.append('}');
        return sb.toString();
    }

    private enum Type {
        CPF, CNPJ
    }
}

