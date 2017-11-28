package br.com.moip.resource.links;

public class TransferLinks {

    private Href self;

    public String getSelf() { return self.getHref(); }

    @Override
    public String toString() {
        return new StringBuilder("Links{")
        .append("self=").append(self)
        .append('}').toString();
    }
}
