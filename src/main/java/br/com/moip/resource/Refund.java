package br.com.moip.resource;

import br.com.moip.resource.links.EscrowLinks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Refund {

    private String id;
    private Status status;
    private List<Event> events = new ArrayList<Event>();
    private Amount amount;
    private Type type;
    private RefundingInstrument refundingInstrument;
    private Date createdAt;
    private EscrowLinks _links;

    public String getId() {
        return id;
    }

    public Amount getAmount() {
        return amount;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public RefundingInstrument getRefundingInstrument() {
        return refundingInstrument;
    }

    public List<Event> getEvents() {
        return events;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public EscrowLinks getLinks() {
        return _links;
    }

    public enum Status {
        REQUESTED, COMPLETED, FAILED
    }

    public enum Type {
        FULL, PARTIAL
    }

    @Override
    public String toString() {
        return new StringBuilder("Refund{")
            .append("id='").append(id).append('\'')
            .append(", status=").append(status)
            .append(", events=").append(events)
            .append(", amount=").append(amount)
            .append(", type=").append(type)
            .append(", refundingInstrument=").append(refundingInstrument)
            .append(", createdAt=").append(createdAt)
            .append(", _links=").append(_links)
            .append("}").toString();
    }

}
