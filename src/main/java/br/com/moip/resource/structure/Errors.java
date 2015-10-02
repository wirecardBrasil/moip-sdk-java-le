package br.com.moip.resource.structure;

public class Errors {
    private String path;
    private String description;

    public Errors(String path, String description) {
        this.path = path;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Errors{" +
                "path='" + path + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
