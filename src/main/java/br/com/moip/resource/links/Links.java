package br.com.moip.resource.links;

public class Links {
    private OrderLink order;
    private PayBoleto payBoleto;

    public OrderLink getOrder() {
        return order;
    }

    public void setOrder(OrderLink order) {
        this.order = order;
    }

    public PayBoleto getPayBoleto() {
        return payBoleto;
    }

    public void setPayBoleto(PayBoleto payBoleto) {
        this.payBoleto = payBoleto;
    }

    @Override
    public String toString() {
        return "Links{" +
                "order=" + order +
                ", payBoleto=" + payBoleto +
                '}';
    }
}
