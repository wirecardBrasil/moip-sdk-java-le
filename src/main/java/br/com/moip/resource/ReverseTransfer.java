package br.com.moip.resource;

import br.com.moip.resource.links.TransferLinks;

import java.util.Date;

public class ReverseTransfer {

    private int fee;
    private int amount;
    private String id;
    private TransferInstrument transferInstrument;
    private TransferStatus status;
    private Date createdAt;
    private TransferLinks _links;

    public int getFee() { return fee; }

    public void setFee(int fee) { this.fee = fee; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public TransferInstrument getTransferInstrument() { return transferInstrument; }

    public void setTransferInstrument(TransferInstrument transferInstrument) { this.transferInstrument = transferInstrument; }

    public TransferStatus getStatus() { return status; }

    public void setStatus(TransferStatus status) { this.status = status; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public TransferLinks getLinks(){ return _links; }

    public void setLinks(TransferLinks _links) { this._links = _links; }

    @Override
    public String toString() {

        return new StringBuilder("Transfer{")
                .append("fee=").append(fee)
                .append(", amount=").append(amount)
                .append(", id=").append(id)
                .append(", transferInstrument=").append(transferInstrument)
                .append(", status=").append(status)
                .append(", createdAt=").append(createdAt)
                .append(", _links=").append(_links)
                .append("}").toString();
    }
}
