package br.com.moip.resource;

import java.util.Date;

public class Transfer {

    private String id;
    private int amount;
    private int fee;
    private TransferStatus status;
    private Date createdAt;
    private Date updatedAt;
    private TransferInstrument transferInstrument;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public void setStatus(TransferStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TransferInstrument getTransferInstrument() {
        return transferInstrument;
    }

    public void setTransferInstrument(TransferInstrument transferInstrument) {
        this.transferInstrument = transferInstrument;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Transfer{");
        sb.append("id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", fee=").append(fee);
        sb.append(", status=").append(status);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", transferInstrument=").append(transferInstrument);
        sb.append('}');
        return sb.toString();
    }
}
