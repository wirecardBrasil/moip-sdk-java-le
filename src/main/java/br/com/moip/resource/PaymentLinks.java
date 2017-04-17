package br.com.moip.resource;

public class PaymentLinks {

    private PaymentLink self = new PaymentLink();

    private PaymentBoletoLink payBoleto = new PaymentBoletoLink();

    public String getSelf() {
        return self.getHref();
    }

    public void setSelf(String link) {
        this.self.setHref(link);
    }

    public String getPayBoleto() {
        return payBoleto.getRedirectHref();
    }

    public void setPayBoleto(String link) {
        this.payBoleto.setRedirectHref(link);
    }

    private class PaymentLink {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    private class PaymentBoletoLink {
        private String redirectHref;

        public String getRedirectHref() {
            return redirectHref;
        }

        public void setRedirectHref(String redirectHref) {
            this.redirectHref = redirectHref;
        }
    }
}
