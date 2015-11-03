package br.com.moip.resource;

public class FundingInstrument {
    private boolean supressCreditCard;
    private boolean supressBoleto;

    public boolean isSupressCreditCard() {
        return supressCreditCard;
    }

    public FundingInstrument setSupressCreditCard(boolean supressCreditCard) {
        this.supressCreditCard = supressCreditCard;
        return this;
    }

    public boolean isSupressBoleto() {
        return supressBoleto;
    }

    public FundingInstrument setSupressBoleto(boolean supressBoleto) {
        this.supressBoleto = supressBoleto;
        return this;
    }

    @Override
    public String toString() {
        return "FundingInstrument{" +
                "supressCreditCard=" + supressCreditCard +
                ", supressBoleto=" + supressBoleto +
                '}';
    }
}