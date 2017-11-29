package br.com.moip.resource.links;

public class TransferLinks {

    private Href self;
    private Href reverse;

    public String getSelf() { return self.getHref(); }

    public String getReverse() { return reverse.getHref(); }

    @Override
    public String toString() {
        return new StringBuilder("Links{")
        .append("reverse=").append(reverse)
        .append(", self=").append(self)
        .append('}').toString();
    }
}
