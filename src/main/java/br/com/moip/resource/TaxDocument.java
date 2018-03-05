package br.com.moip.resource;

public class TaxDocument {

    private Type type;
    private String number;

    public Type getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "TaxDocument{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public enum Type {
        CPF, CNPJ
    }
}

