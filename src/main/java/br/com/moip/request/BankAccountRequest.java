package br.com.moip.request;

public class BankAccountRequest {

    private String id;
    private String bankNumber;
    private String agencyNumber;
    private String agencyCheckNumber;
    private String accountNumber;
    private String accountCheckNumber;
    private Type type;
    private HolderRequest holder;

    public void id(String id) {
        this.id = id;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public BankAccountRequest bankNumber(final String bankNumber) {
        this.bankNumber = bankNumber;
        return this;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public BankAccountRequest agencyNumber(final String agencyNumber) {
        this.agencyNumber = agencyNumber;
        return this;
    }

    public String getAgencyCheckNumber() {
        return agencyCheckNumber;
    }

    public BankAccountRequest agencyCheckNumber(final String agencyCheckNumber) {
        this.agencyCheckNumber = agencyCheckNumber;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankAccountRequest accountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getAccountCheckNumber() {
        return accountCheckNumber;
    }

    public BankAccountRequest accountCheckNumber(final String accountCheckNumber) {
        this.accountCheckNumber = accountCheckNumber;
        return this;
    }

    public Enum getType() {
        return type;
    }

    public HolderRequest getHolder() {
        return holder;
    }

    public BankAccountRequest holder(final HolderRequest holder) {
        this.holder = holder;
        return this;
    }

    public BankAccountRequest checking(){
        this.type = Type.CHECKING;
        return this;
    }

    public BankAccountRequest saving(){
        this.type = Type.SAVING;
        return this;
    }

    private enum Type {
        CHECKING, SAVING;
    }

}
