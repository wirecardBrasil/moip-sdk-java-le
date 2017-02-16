package br.com.moip.request;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;


public class CreditCardRequest {

    private String publicKey;
    private String number;
    private String cvc;
    private String expirationMonth;
    private String expirationYear;
    private String hash;
    private HolderRequest holder;

    public String getHash() {
        return hash;
    }

    public CreditCardRequest hash(final String hash) {
        this.hash = hash;

        return this;
    }

    public HolderRequest getHolder() {
        return holder;
    }

    public CreditCardRequest holder(final HolderRequest holder) {
        this.holder = holder;

        return this;
    }

    @Override
    public String toString() {
        return "CreditCardRequest{" +
                "hash='" + hash + '\'' +
                ", holder=" + holder +
                '}';
    }

    public CreditCardRequest publicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public CreditCardRequest cardNumber(String number) {
        this.number = number;
        return this;
    }

    public CreditCardRequest cvc(String cvc) {
        this.cvc = cvc;
        return this;
    }

    public CreditCardRequest expirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
        return this;
    }

    public CreditCardRequest expirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public String getCvc() {
        return cvc;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }
}
