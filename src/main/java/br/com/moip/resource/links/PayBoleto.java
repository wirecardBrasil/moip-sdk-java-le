package br.com.moip.resource.links;

public class PayBoleto {

    private String printHref;
    private String redirectHref;

    public String getPrintHref() {
        return printHref;
    }

    public String getRedirectHref() {
        return redirectHref;
    }

    @Override
    public String toString() {
        return new StringBuilder("PayBoleto{")
            .append("printHref=").append(printHref)
            .append("redirectHref=").append(redirectHref)
            .append('}').toString();
    }
}
