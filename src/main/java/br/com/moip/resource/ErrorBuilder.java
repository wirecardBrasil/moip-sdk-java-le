package br.com.moip.resource;

public class ErrorBuilder extends Error {

    public ErrorBuilder code(final String code) {
        this.setCode(code);
        return this;
    }

    public ErrorBuilder path(final String path) {
        this.setPath(path);
        return this;
    }

    public ErrorBuilder description(final String description) {
        this.setDescription(description);
        return this;
    }

    public Error build() {
        return this;
    }
}
