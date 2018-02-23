package br.com.moip.resource.links;

public class CustomerLinks {

    private Self selfHref;

    private HostedAccount hostedAccountHref;

    public String getSelfHref() { return selfHref.href; }

    public String getHostedAccountHref() { return hostedAccountHref.redirectHref; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append('{')
                .append("self={href='").append(selfHref).append("\'}")
                .append(", hostedAccount={redirectHref='").append(hostedAccountHref).append("\'}")
                .append('}').toString();
    }

    private class Self {

        private String href;

        public String getHref() { return href; }
    }

    private class HostedAccount {

        private String redirectHref;

        public String getRedirectHref() { return redirectHref; }
    }
}
