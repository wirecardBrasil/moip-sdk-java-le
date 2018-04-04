package br.com.moip.examples;

import br.com.moip.request.TransferRequest;
import br.com.moip.request.TransferInstrumentRequest;
import br.com.moip.request.BankAccountRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.MoipAccountRequest;
import br.com.moip.API;
import br.com.moip.examples.setup.Setup;
import br.com.moip.resource.Transfer;
import br.com.moip.response.TransferListResponse;

public class TransferExamples {

    /**
     * The Transfer is a fund movement between the Moip account
     * and another payment account (it can be a bank account or
     * another Moip account).
     *
     * Read more about transfers on:
     * https://dev.moip.com.br/v2.0/docs/transfer%C3%AAncias
     * https://dev.moip.com.br/v2/reference#transfer%C3%AAncias-1
     */

    // API instance
    API api = new Setup().buildSetup();

    /*
     * This method allows you to create a transference to a bank account.
     * TIP: you can use a saved bank account by your ID (BKA-XXXXXXXXX)
     */
    public void createTransferToBankAccount() {

        Transfer transfer = api.transfer().create(new TransferRequest()
            .amount(1000)
            .transferInstrument(new TransferInstrumentRequest()
                .bankAccount(new BankAccountRequest()
                    .bankNumber("001")
                    .agencyNumber("1111")
                    .agencyCheckNumber("2")
                    .accountNumber("9999")
                    .accountCheckNumber("8")
                    .checking()
                    .holder(new HolderRequest()
                        .fullname("Nome do Portador")
                        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    )
                )
            )
        );
    }

    // This method allows you to create a transference to a Moip account.
    public void createTransferToMoipAccount() {

        Transfer transfer = api.transfer().create(new TransferRequest()
            .amount(1000)
            .transferInstrument(new TransferInstrumentRequest()
                .moipAccount(new MoipAccountRequest("MPA-5D5053C0B4A4"))        // Moip account ID
            )
        );
    }

    // This method allows you to get a transfer.
    public void getTransfer() {

        Transfer createdTransfer = api.transfer().get("TRA-3TORC2YY0R39");
    }

    // This method list all created transfers.
    public void listTransfers() {

        TransferListResponse transferListResponse = api.transfer().list();
    }

    // This method allows you to revert a transfer.
    public void revertTransfer() {

        Transfer revertTransfer = api.transfer().reverse("TRA-3TORC2YY0R39");
    }
}
