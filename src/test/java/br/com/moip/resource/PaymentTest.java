package br.com.moip.resource;

import br.com.moip.resource.structure.Errors;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PaymentTest {

    @Test
    public void whenHasValidationError() {
        Payment payment = new Payment();
        ArrayList<Errors> errors = new ArrayList<Errors>();
        errors.add(new Errors("path.to.error", "some error"));

        payment.setErrors(errors);

        assertTrue(payment.hasValidationError());
    }

    @Test
    public void whenHasNotValidationError() {
        Payment payment = new Payment();

        assertFalse(payment.hasValidationError());
    }
}
