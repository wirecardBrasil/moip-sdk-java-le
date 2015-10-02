package br.com.moip.resource.links;

public class PayBoleto {
    private String redirectHref;

    public String getRedirectHref() {
        return redirectHref;
    }

    public void setRedirectHref(String redirectHref) {
        this.redirectHref = redirectHref;
    }

    @Override
    public String toString() {
        return "PayBoleto{" +
                "redirectHref='" + redirectHref + '\'' +
                '}';
    }
}
