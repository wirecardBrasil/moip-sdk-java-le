package br.com.moip.request;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class CreditCardRequestTest {

    @Test
    public void shouldEncryptCreditCardInfo() {
        CreditCardRequest creditCardRequest = new CreditCardRequest()
                .cardNumber("1223")
                .cvc("123")
                .expirationMonth("12")
                .expirationYear("88");
        Assert.assertEquals("1223", creditCardRequest.getNumber());
        Assert.assertEquals("123", creditCardRequest.getCvc());
        Assert.assertEquals("12", creditCardRequest.getExpirationMonth());
        Assert.assertEquals("88", creditCardRequest.getExpirationYear());
    }

}