package br.com.moip.resource;

import java.util.Date;

public class BankAccount {

    private String id;
    private String agencyNumber;
    private String agencyCheckNumber;
    private String bankName;
    private String bankNumber;
    private String accountNumber;
    private Holder holder;
    private Type type;
    private String status;
    private Date createdAt;
    private Links _links;

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
        return _links;
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
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", agencyNumber='" + agencyNumber + '\'' +
                ", agencyCheckNumber='" + agencyCheckNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankNumber='" + bankNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", holder=" + holder +
                ", type=" + type +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", _links=" + _links +
                '}';
    }
}
