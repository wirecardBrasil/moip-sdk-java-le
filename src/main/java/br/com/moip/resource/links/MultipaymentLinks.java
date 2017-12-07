package br.com.moip.resource.links;

public class MultipaymentLinks {

    private Href self;
    private Href multiorder;
    private Checkout checkout;

    public String self() {
        return self.getHref();
    }

    public String multiorderLink() { return multiorder.getHref(); }

    public Checkout checkout() { return checkout; }

    @Override
    public String toString() {
        return new StringBuilder("MultipaymentLinks{")
                .append("self=").append(self)
                .append(", multiorder=").append(multiorder)
                .append(", checkout=").append(checkout)
                .append('}').toString();
    }
}
