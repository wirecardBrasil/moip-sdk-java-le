package br.com.moip.request;

public class DebitCardRequest {

    private String first6;
    private String last4;

    public DebitCardRequest first6(final String first6){
        this.first6 = first6;
        return this;
    }

    public String getFirst6() {
        return first6;
    }

    public DebitCardRequest last4(final String last4){
        this.last4 = last4;
        return this;
    }

    public String getLast4() {
        return last4;
    }

}