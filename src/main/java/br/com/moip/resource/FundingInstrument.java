package br.com.moip.resource;

public class FundingInstrument {
    private boolean supressCreditCard;
    private boolean supressBoleto;

    public FundingInstrument() {
    }

    public FundingInstrument(boolean supressCreditCard, boolean supressBoleto) {
        this.supressCreditCard = supressCreditCard;
        this.supressBoleto = supressBoleto;
    }

    public boolean isSupressCreditCard() {
        return supressCreditCard;
    }

    public void setSupressCreditCard(boolean supressCreditCard) {
        this.supressCreditCard = supressCreditCard;
    }

    public boolean isSupressBoleto() {
        return supressBoleto;
    }

    public void setSupressBoleto(boolean supressBoleto) {
        this.supressBoleto = supressBoleto;
    }

    @Override
    public String toString() {
        return "FundingInstrument{" +
                "supressCreditCard=" + supressCreditCard +
                ", supressBoleto=" + supressBoleto +
                '}';
    }
}