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

    private enum Type {
        CHECKING, SAVING;
    }
}
