package br.com.moip.request;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class CreditCardRequestTest {

    @Ignore
    @Test
    public void shouldEncryptCreditCardInfo() {
        String s = new CreditCardRequest()
                .cardNumber("1223")
                .cvc("123")
                .expirationMonth("12")
                .expirationYear("88")
                .publicKey("-----BEGIN PUBLIC KEY-----\n" +
                        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoBttaXwRoI1Fbcond5mS\n" +
                        "7QOb7X2lykY5hvvDeLJelvFhpeLnS4YDwkrnziM3W00UNH1yiSDU+3JhfHu5G387\n" +
                        "O6uN9rIHXvL+TRzkVfa5iIjG+ap2N0/toPzy5ekpgxBicjtyPHEgoU6dRzdszEF4\n" +
                        "ItimGk5ACx/lMOvctncS5j3uWBaTPwyn0hshmtDwClf6dEZgQvm/dNaIkxHKV+9j\n" +
                        "Mn3ZfK/liT8A3xwaVvRzzuxf09xJTXrAd9v5VQbeWGxwFcW05oJulSFjmJA9Hcmb\n" +
                        "DYHJT+sG2mlZDEruCGAzCVubJwGY1aRlcs9AQc1jIm/l8JwH7le2kpk3QoX+gz0w\n" +
                        "WwIDAQAB\n" +
                        "-----END PUBLIC KEY-----").hashCard();
        Assert.assertEquals("legal", s);
    }

}