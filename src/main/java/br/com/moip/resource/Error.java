package br.com.moip.resource;

public class Error {

    private String code;
    private String path;
    private String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Errors{" +
                "code='" + getCode() + "'" +
                ", path='" + getPath() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
