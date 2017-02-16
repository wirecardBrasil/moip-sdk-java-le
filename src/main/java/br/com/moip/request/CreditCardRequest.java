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


    private static Cipher cipher;

    public String hashCard() {
       // Security.addProvider();

        StringBuilder builder = new StringBuilder();
        builder.append("number=").append(number).append("&");
        if (cvc != null)
            builder.append("cvc=").append(cvc).append("&");
        builder.append("expirationMonth=").append(expirationMonth).append("&");
        builder.append("expirationYear=").append(expirationYear);

        try {
            try {
                cipher = Cipher.getInstance("RSA/None/PKCS1Padding", "BS");
            } catch (SecurityException se) {
                //workaround for tests
                cipher = Cipher.getInstance("RSA");
            }

            BufferedReader pemReader = null;
            pemReader = new BufferedReader(new InputStreamReader(
                    new ByteArrayInputStream(publicKey.getBytes("UTF-8"))));

            StringBuffer content = new StringBuffer();
            String line = null;
            while ((line = pemReader.readLine()) != null) {
                if (line.indexOf("-----BEGIN PUBLIC KEY-----") != -1) {
                    while ((line = pemReader.readLine()) != null) {
                        if (line.indexOf("-----END PUBLIC KEY") != -1) {
                            break;
                        }
                        content.append(line.trim());
                    }
                    break;
                }
            }
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            //cipher.init(Cipher.ENCRYPT_MODE, keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decode(content.toString()))));
            byte[] cipherText = cipher.doFinal(builder.toString().getBytes());

            // return Base64.encode(cipherText);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
//        } catch (Base64DecodingException e) {
//            e.printStackTrace();
        }

        return null;
//        InputStream stream = new ByteArrayInputStream(publicKey.getBytes());
//        return PPK.publicKey(stream).encryptAsBase64(builder.toString());
    }


}
