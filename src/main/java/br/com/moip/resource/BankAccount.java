package br.com.moip.resource;

import java.util.Date;

public class BankAccount {

    private String id;
    private String agencyNumber;
    private String agencyCheckNumber;
    private String bankName;
    private String bankNumber;
    private String accountNumber;
    private String accountCheckNumber;
    private Holder holder;
    private Type type;
    private String status;
    private Date createdAt;
    private Links links;

    public String getId() {
        return id;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public String getAgencyCheckNumber() {
        return agencyCheckNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountCheckNumber() {
        return accountCheckNumber;
    }

    public Holder getHolder() {
        return holder;
    }

    public Type getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Links getLinks() {
        return links;
    }

    public boolean isChecking(){
        return getType().equals(Type.CHECKING);
    }

    public boolean isSaving(){
        return getType().equals(Type.SAVING);
    }

    private enum Type {
        CHECKING, SAVING;
    }

    @Override
    public String toString() {
        return new StringBuilder("BankAccount{")
                .append("id='").append(id).append('\'')
                .append(", agencyNumber='").append(agencyNumber).append('\'')
                .append(", agencyCheckNumber='").append(agencyCheckNumber).append('\'')
                .append(", bankName='").append(bankName).append('\'')
                .append(", bankNumber='").append(bankNumber).append('\'')
                .append(", accountNumber='").append(accountNumber).append('\'')
                .append(", accountCheckNumber='").append(accountCheckNumber).append('\'')
                .append(", holder=").append(holder)
                .append(", type=").append(type)
                .append(", status='").append(status).append('\'')
                .append(", createdAt=").append(createdAt)
                .append(", _links=").append(links)
                .append('}').toString();
    }
}