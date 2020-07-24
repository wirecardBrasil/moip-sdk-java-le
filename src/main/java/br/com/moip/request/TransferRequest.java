package br.com.moip.request;

public class TransferRequest {

    private Integer amount;
    private String description;
    private TransferInstrumentRequest transferInstrument;

    public TransferRequest amount(Integer amount){
        this.amount = amount;

        return this;
    }

    public TransferRequest description(String description){
        this.description = description;

        return this;
    }

    public Integer getAmount() { return amount; }

    public String getDescription() {
        return description;
    }

    public TransferRequest transferInstrument(TransferInstrumentRequest transferInstrument){
        this.transferInstrument = transferInstrument;

        return this;
    }

    public TransferInstrumentRequest getTransferInstrument() { return transferInstrument; }

    @Override
    public String toString(){
        return new StringBuilder("TransferRequest{")
                .append("amount=").append(amount)
                .append(", transferInstrument=").append(transferInstrument)
                .append("}").toString();
    }
}
