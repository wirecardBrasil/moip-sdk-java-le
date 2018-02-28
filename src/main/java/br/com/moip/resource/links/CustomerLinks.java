package br.com.moip.resource.links;

public class CustomerLinks {

    private Href self;

    private HostedAccount hostedAccount;

    public String getSelfHref() { return self.getHref(); }

    public String getHostedAccountHref() { return hostedAccount.getRedirectHref(); }

    @Override
    public String toString() {
        return new StringBuilder()
                .append('{')
                .append("self={href='").append(self).append("\'}")
                .append(", hostedAccount={redirectHref='").append(hostedAccount).append("\'}")
                .append('}').toString();
    }

    private class HostedAccount {

        private String redirectHref;

        public String getRedirectHref() { return redirectHref; }
    }
}
