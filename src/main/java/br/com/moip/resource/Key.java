package br.com.moip.resource;

public class Key {

    private Keys keys;

    public Keys getKeys() {
        return keys;
    }

    @Override
    public String toString() {
        return new StringBuilder("Key{")
                .append("keys=").append(keys)
                .append('}').toString();
    }

    public static final class Keys {

        private BasicAuth basicAuth;
        private String encryption;

        public BasicAuth getBasicAuth() {
            return basicAuth;
        }

        public String getEncryption() {
            return encryption;
        }

        @Override
        public String toString() {
            return new StringBuilder("Keys{").append("basicAuth=").append(basicAuth)
                    .append(", encryption='").append(truncate(encryption, 10)).append('\'')
                    .append('}').toString();
        }
    }

    public static final class BasicAuth {

        private String token;
        private String secret;

        public String getToken() {
            return token;
        }

        public String getSecret() {
            return secret;
        }

        @Override
        public String toString() {
            return new StringBuilder("BasicAuth{")
                    .append("token='").append(truncate(token, 5)).append('\'')
                    .append(", secret='").append(truncate(secret, 5)).append('\'')
                    .append('}').toString();
        }
    }

    private static final String truncate(final String str, final int length) {
        if (str != null && str.length() > length) {
            return str.substring(0, length) + "...";
        }

        return str;
    }
}
