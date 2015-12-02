package br.com.moip.resource;

public class ErrorBuilder {

    private final Error error = new Error();

    public ErrorBuilder code(final String code) {
        error.setCode(code);

        return this;
    }

    public ErrorBuilder path(final String path) {
        error.setPath(path);

        return this;
    }

    public ErrorBuilder description(final String description) {
        error.setDescription(description);

        return this;
    }

    public Error build() {
        return error;
    }
}
