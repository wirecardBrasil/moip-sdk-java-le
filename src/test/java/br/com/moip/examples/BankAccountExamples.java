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

    // API instance
    API api = new Setup().buildSetup();

    // OKAY
    public void createBankAccount() {

        BankAccount createdBankAccount = api.bankAccount().create("MPA-CULBBYHD11",
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

    // OKAY
    public void getBankAccount() {

        BankAccount getCreatedBankAccount = api.bankAccount().get("BKA-JS57AWG1G94U");
    }

    // OKAY
    public void listBankAccounts() {

        List<BankAccount> bankAccountsList = api.bankAccount().getList("MPA-CULBBYHD11");
    }

    // OKAY
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

    // OKAY
    public void deleteBankAccount() {

        api.bankAccount().delete("BKA-JS57AWG1G94U");
    }
}
