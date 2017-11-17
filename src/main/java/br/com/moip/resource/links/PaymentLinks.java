package br.com.moip.resource.links;

public class PaymentLinks {
    private Href self;
    private Href order;
    private RedirectHref payOnlineBankDebitItau;
    private PayBoleto payBoleto;

    public String self() {
        return self.getHref();
    }

    public String orderLink() {
        return order.getHref();
    }

    public String orderTitle() {
        return order.getTitle();
    }

    public Href getLink() {
        return self;
    }

    public Href getOrder() {
        return order;
    }

    public RedirectHref getPayOnlineBankDebitItau() {
        return payOnlineBankDebitItau;
    }

    public PayBoleto getPayBoleto() {
        return payBoleto;
    }

    public String payOnlineBankDebitLink() {
        return payOnlineBankDebitItau.getRedirectHref();
    }

    public String payBoletoLink() {
        return payBoleto.getRedirectHref();
    }

    public String payBoletoPrintLink() {
        return payBoleto.getPrintHref();
    }

    @Override
    public String toString() {
        return new StringBuilder("PaymentLinks{")
            .append("self=").append(self)
            .append(", order=").append(order)
            .append(", payOnlineBankDebitItau=").append(payOnlineBankDebitItau)
            .append(", payBoleto=").append(payBoleto)
            .append('}').toString();
    }
}
