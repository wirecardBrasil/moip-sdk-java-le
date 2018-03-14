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

    // API instance
    API api = new Setup().buildSetup();

    // OKAY
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

    // OKAY
    public void createTransferToMoipAccount() {

        Transfer transfer = api.transfer().create(new TransferRequest()
            .amount(1000)
            .transferInstrument(new TransferInstrumentRequest()
                .moipAccount(new MoipAccountRequest("MPA-5D5053C0B4A4"))
            )
        );
    }

    // OKAY
    public void getTransfer() {

        Transfer createdTransfer = api.transfer().get("TRA-3TORC2YY0R39");
    }

    // OKAY
    public void listTransfers() {

        TransferListResponse transferListResponse = api.transfer().list();
    }

    // OKAY
    public void revertTransfer() {

        Transfer revertTransfer = api.transfer().reverse("TRA-3TORC2YY0R39");
    }
}
