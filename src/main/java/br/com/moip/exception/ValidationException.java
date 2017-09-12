package br.com.moip.exception;

import br.com.moip.resource.Error;
import br.com.moip.resource.Errors;

import java.util.List;

public class ValidationException extends MoipException {

    private final int responseCode;
    private final String responseStatus;
    private final Errors errors;

    public ValidationException(final int responseCode, final String responseStatus, final Errors errors) {
        this.responseCode = responseCode;
        this.responseStatus = responseStatus;
        this.errors = errors;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public Errors getError() {
        return errors;
    }

    public List<Error> getErrors() {
        return errors.getErrors();
    }
}
