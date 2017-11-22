package br.com.moip.resource.links;

public class AccountLinks {

    private Href self;
    private Href setPassword;

    public String getSelf() { return self.getHref(); }

    public String getSetPassword() { return setPassword.getHref(); }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Links{");
        sb.append("self=").append(self);
        sb.append("setPassword=").append(setPassword);
        sb.append('}');
        return sb.toString();
    }
}
