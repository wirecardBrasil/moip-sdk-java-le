package br.com.moip.resource.links;

public class RedirectHref {

    private String redirectHref;

    public String getRedirectHref() {
        return redirectHref;
    }

    @Override
    public String toString() {
        return new StringBuilder("RedirectHref{")
                .append("redirectHref='").append(redirectHref).append('\'')
                .append('}').toString();
    }
}
