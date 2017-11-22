package br.com.moip.resource;

import br.com.moip.resource.links.Href;

public class AccountLinks {

    private Href self;
    private Href setPassword;

    public Href getSelf() { return self; }

    public void setSelf(Href self) { this.self = self; }

    public Href getSetPassword() { return setPassword; }

    public void setSetPassword(Href setPassword) { this.setPassword = setPassword; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Links{");
        sb.append("self=").append(self);
        sb.append("setPassword=").append(setPassword);
        sb.append('}');
        return sb.toString();
    }
}
