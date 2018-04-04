package br.com.moip.examples;

import br.com.moip.request.BankAccountRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.BankAccount;
import br.com.moip.API;
import br.com.moip.examples.setup.Setup;
import org.junit.Test;

import java.util.List;

public class BankAccountExamples {

    /**
     * The Moip bank account is the bank address of a Moip Account.
     * This API allows you to create (save), get, list,
     * update and delete a bank account.
     *
     * Read more about bank account on:
     * https://dev.moip.com.br/v2/reference#contas-banc%C3%A1rias-1
     */

    // API instance
    API api = new Setup().buildSetup();

    /*
     * This method allows you to save an bank account.
     * After save the bank account, the API will return an ID (BKA-XXXXXXXXX)
     * to use this bank account on futures requests.
     */
    public void createBankAccount() {

        BankAccount createBankAccount = api.bankAccount().create("MPA-CULBBYHD11",
            new BankAccountRequest()
                .bankNumber("237")
                .agencyNumber("12346")
                .agencyCheckNumber("0")
                .accountNumber("12345679")
                .accountCheckNumber("7")
                .checking()
                .holder(new HolderRequest()
                    .fullname("Demo Moip")
                    .taxDocument(TaxDocumentRequest.cpf("62213453322"))
                )
        );
    }

    // This method allows you to get a bank account.
    public void getBankAccount() {

        BankAccount getCreatedBankAccount = api.bankAccount().get("BKA-JS57AWG1G94U");
    }

    // This method list all saved bank account.
    public void listBankAccounts() {

        List<BankAccount> bankAccountsList = api.bankAccount().getList("MPA-CULBBYHD11");
    }

    // This method allows you to update an saved bank account.
    public void updateBankAccount() {

        BankAccount createdBankAccount = api.bankAccount().update("BKA-JS57AWG1G94U",
            new BankAccountRequest()
                .bankNumber("237")
                .agencyNumber("12345")
                .agencyCheckNumber("8")
                .accountNumber("12345678")
                .accountCheckNumber("8")
                .checking()
                .holder(new HolderRequest()
                    .fullname("New Demo Moip")
                    .taxDocument(TaxDocumentRequest.cpf("62213453322"))
                )
        );
    }

    // This method allows you to delete an saved bank account.
    public void deleteBankAccount() {

        api.bankAccount().delete("BKA-JS57AWG1G94U");
    }
}
