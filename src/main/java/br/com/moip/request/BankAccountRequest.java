package br.com.moip.request;

public class BankAccountRequest {

    private String bankNumber;
    private String agencyNumber;
    private String agencyCheckNumber;
    private String accountNumber;
    private String accountCheckNumber;
    private Enum type;
    private HolderRequest holder;

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public String getAgencyCheckNumber() {
        return agencyCheckNumber;
    }

    public void setAgencyCheckNumber(String agencyCheckNumber) {
        this.agencyCheckNumber = agencyCheckNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountCheckNumber() {
        return accountCheckNumber;
    }

    public void setAccountCheckNumber(String accountCheckNumber) {
        this.accountCheckNumber = accountCheckNumber;
    }

    public Enum getType() {
        return type;
    }

    public HolderRequest getHolder() {
        return holder;
    }

    public void setHolder(HolderRequest holder) {
        this.holder = holder;
    }

    public void checking(){
        this.type = Type.CHECKING;
    }

    public void saving(){
        this.type = Type.SAVING;
    }

    private enum Type {
        CHECKING, SAVING;
    }

}
