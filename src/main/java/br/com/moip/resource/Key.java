package br.com.moip.resource;

public class Key {

    private Keys keys;

    public Keys getKeys() {
        return keys;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Key{");
        sb.append("keys=").append(keys);
        sb.append('}');
        return sb.toString();
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
            final StringBuilder sb = new StringBuilder("Keys{");
            sb.append("basicAuth=").append(basicAuth);
            sb.append(", encryption='").append(truncate(encryption, 10)).append('\'');
            sb.append('}');
            return sb.toString();
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
            final StringBuilder sb = new StringBuilder("BasicAuth{");
            sb.append("token='").append(truncate(token, 5)).append('\'');
            sb.append(", secret='").append(truncate(secret, 5)).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    private static final String truncate(final String str, final int length) {
        if (str != null && str.length() > length) {
            return str.substring(0, length) + "...";
        }

        return str;
    }
}
