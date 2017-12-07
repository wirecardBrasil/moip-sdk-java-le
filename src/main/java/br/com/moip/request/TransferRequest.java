package br.com.moip.request;

public class TransferRequest {

    private Integer amount;
    private TransferInstrumentRequest transferInstrument;

    public TransferRequest amount(Integer amount){
        this.amount = amount;

        return this;
    }

    public Integer getAmount() { return amount; }

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
