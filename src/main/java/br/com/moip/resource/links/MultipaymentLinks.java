package br.com.moip.resource.links;

public class MultipaymentLinks {

    private Href self;
    private Href multiorder;

    public String self() {
        return self.getHref();
    }

    public String multiorderLink() {return multiorder.getHref();}

    @Override
    public String toString() {
        return new StringBuilder("MultipaymentLinks{")
                .append("self='").append(self)
                .append("multiorder='").append(multiorder)
                .append('}').toString();
    }
}
