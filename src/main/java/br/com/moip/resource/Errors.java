package br.com.moip.resource;

import java.util.ArrayList;
import java.util.List;

public class Errors {

    private final List<Error> errors = new ArrayList<Error>();

    public List<Error> getErrors() {
        return errors;
    }

    public void setError(ErrorBuilder error) { this.errors.add(error); }
}
