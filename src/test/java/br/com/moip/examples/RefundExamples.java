package br.com.moip.examples;

import br.com.moip.request.RefundRequest;
import br.com.moip.request.RefundingInstrumentRequest;
import br.com.moip.request.BankAccountRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.response.RefundsListResponse;
import br.com.moip.resource.Refund;
import br.com.moip.API;
import br.com.moip.examples.setup.Setup;
import org.junit.Test;

public class RefundExamples {

    // API instance
    API api = new Setup().buildSetup();

    // OKAY
    public void createFullRefundToCreditCard() {

        Refund refund = api.refund().order(new RefundRequest("PAY-98NYKRYSNJOU")
            .refundingInstrument(new RefundingInstrumentRequest()
                .creditCard()
            )
        );
    }

    // OKAY
    public void createPartialRefundToCreditCard() {

        Refund refund = api.refund().order(new RefundRequest("ORD-OYEHY0I2CCE0")
            .amount(500)
            .refundingInstrument(new RefundingInstrumentRequest()
                .creditCard()
            )
        );
    }

    // OKAY
    public void createFullRefundToBankAccount() {

        Refund refund = api.refund().order(new RefundRequest("PAY-98CMJRI3VPWH")
            .refundingInstrument(new RefundingInstrumentRequest()
                .bankAccount(new BankAccountRequest()
                    .checking()
                    .bankNumber("001")
                    .agencyNumber("4444444")
                    .agencyCheckNumber("2")
                    .accountNumber("1234")
                    .accountCheckNumber("1")
                    .holder(new HolderRequest()
                        .fullname("Jose Silva")
                        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    )
                )
            )
        );
    }

    // OKAY
    public void getRefund() {

        Refund refund = api.refund().get("REF-N28AQVOY928E");
    }

    // OKAY
    public void listRefunds() {

        RefundsListResponse refunds = api.refund().list("ORD-SZZMQ42WNYSR");        // can be by PAY-
    }
}
