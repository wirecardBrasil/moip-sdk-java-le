package br.com.moip.resource.links;

public class EscrowLinks {

    private Href self;
    private Href order;
    private Href payment;

    public String self() {
        return self.getHref();
    }

    public String orderLink() {
        return order.getHref();
    }

    public String orderTitle() {
        return order.getTitle();
    }

    public String paymentLink() {
        return payment.getHref();
    }

    public String paymentTitle() {
        return payment.getTitle();
    }

    public Href getLink() {
        return self;
    }

    public Href getOrder() {
        return order;
    }

    public Href getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return new StringBuilder("EscrowLinks{")
            .append("self='").append(self)
            .append(", order='").append(order)
            .append(", payment='").append(payment)
            .append('}').toString();
    }
}
