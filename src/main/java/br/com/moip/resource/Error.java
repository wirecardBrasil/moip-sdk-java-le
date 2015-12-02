package br.com.moip.resource;

public class Error {

    private String code;
    private String path;
    private String description;

    void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    void setPath(String path) {
        this.path = path;
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
