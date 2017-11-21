package br.com.moip.resource;

import br.com.moip.resource.links.Href;

public class AccountLinks {

    private Self self;
    private Password setPassword;

    public Self getSelf() { return self; }

    public void setSelf(Self self) { this.self = self; }

    public Password getSetPassword() { return setPassword; }

    public void setSetPassword(Password setPassword) { this.setPassword = setPassword; }

    public class Self{

        private String href;

        public String getHref() { return href; }

        public void setHref(String href) { this.href = href; }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Self{");
            sb.append("href=").append(href);
            sb.append('}');
            return sb.toString();
        }
    }
    public class Password{

        private String href;

        public String getHref() { return href; }

        public void setHref(String href) { this.href = href; }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("SetPassword{");
            sb.append("href=").append(href);
            sb.append('}');
            return sb.toString();
        }
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Links{");
        sb.append("self=").append(self);
        sb.append("setPassword=").append(setPassword);
        sb.append('}');
        return sb.toString();
    }
}
