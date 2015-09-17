package br.com.moip;

import br.com.moip.resource.structure.Errors;

import java.util.List;

public class ValidationException extends RuntimeException {
    private List<Errors> errors;

    public ValidationException(){
    }

    public ValidationException(final String message) {
        super(message);
    }

    public ValidationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ValidationException(final Throwable cause) {
        super(cause);
    }

    public ValidationException(List<Errors> errors) {
        this.errors = errors;
    }

    public List<Errors> getErrors() {
        return errors;
    }
}
