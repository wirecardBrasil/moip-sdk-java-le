package br.com.moip.resource;

import java.util.List;

public class Entry {

    private String external_id;
    private List<Reschedule> reschedule;
    private String scheduledFor;
    private Status status;
    private MoipAccount moipAccount;
    private List<Fees> fees;
    private String type;
    private int grossAmount;
    private int moipAccountId;
    private String updatedAt;
    private int id;
    private Installment installment;
    private List<References> references;
    private String eventId;
    private String createdAt;
    private String description;
    private boolean blocked;
    private String settledAt;
    private int liquidAmount;

    public String getExternalId() { return external_id; }

    public List<Reschedule> getReschedule() { return reschedule; }

    public String getScheduledFor() { return scheduledFor; }

    public Status getStatus() { return status; }

    public MoipAccount getMoipAccount() { return moipAccount; }

    public String getAccountMoipAccount() { return moipAccount.getAccount(); }

    public List<Fees> getFees() { return fees; }

    public String getType() { return type; }

    public int getGrossAmount() { return grossAmount; }

    public int getMoipAccountId() { return moipAccountId; }

    public String getUpdatedAt() { return updatedAt; }

    public int getId() { return id; }

    public Installment getInstallment() { return installment; }

    public List<References> getReferences() { return references; }

    public String getEventId() { return eventId; }

    public String getCreatedAt() { return createdAt; }

    public String getDescription() { return description; }

    public boolean getBlocked() { return blocked; }

    public String getSettledAt() { return settledAt; }

    public int getLiquidAmount() { return liquidAmount; }

    private class Reschedule {}

    public class References {

        private String value;
        private String type;

        public String getValue() { return value; }

        public String getType() { return type; }

        @Override
        public String toString() {
            return new StringBuilder("References{")
                    .append("value='").append(value).append('\'')
                    .append(", type=").append(type)
                    .append('}').toString();
        }
    }

    public enum Status {
        SCHEDULED, SETTLED
    }

    @Override
    public String toString() {
        return new StringBuilder("Entry{")
                .append("external_id=").append(external_id)
                .append(", reschedule=").append(reschedule)
                .append(", scheduledFor=").append(scheduledFor)
                .append(", status=").append(status)
                .append(", moipAccount={ account").append(moipAccount)
                .append(", fees=").append(fees)
                .append(", type=").append(type)
                .append(", grossAmount=").append(grossAmount)
                .append(", moipAccountId=").append(moipAccountId)
                .append(", updatedAt=").append(updatedAt)
                .append(", id=").append(id)
                .append(", installment=").append(installment)
                .append(", references= ").append(references)
                .append(", eventId=").append(eventId)
                .append(", createdAt=").append(createdAt)
                .append(", description=").append(description)
                .append(", blocked=").append(blocked)
                .append(", settledAt=").append(settledAt)
                .append(", liquidAmount=").append(liquidAmount)
                .append('}').toString();
    }
}
