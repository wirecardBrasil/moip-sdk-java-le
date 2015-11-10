package br.com.moip.resource;

public class TaxDocument {

    private Type type;
    private String number;

    private TaxDocument() {
    }

    public Type getType() {
        return type;
    }

    private void setType(final Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public static TaxDocument cpf(final String number) {
        TaxDocument taxDocument = new TaxDocument();

        taxDocument.setType(Type.CPF);
        taxDocument.setNumber(number);

        return taxDocument;
    }

    @Override
    public String toString() {
        return "TaxDocument{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    private enum Type {
        CPF, CNPJ
    }
}

