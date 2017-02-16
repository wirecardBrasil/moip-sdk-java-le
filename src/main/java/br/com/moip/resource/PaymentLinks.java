package br.com.moip.resource;

public class PaymentLinks {

    private PaymentLink self = new PaymentLink();

    public String getSelf() {
        return self.getHref();
    }

    public void setSelf(String link) {
        this.self.setHref(link);
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
}
