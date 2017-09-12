package br.com.moip.request;

import br.com.moip.util.GsonFactory;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class RefundRequestTest extends RequestTest {

    @Test
    public void testRefundRequestCreditCardPartial() throws JSONException {
        RefundRequest refund = new RefundRequest("ORD-89SOQ6FMPJPX")
            .refundingInstrument(new RefundingInstrumentRequest().creditCard())
            .amount(100000);
        String refundJSON = new GsonFactory().gson().toJson(refund);
        JsonObject expectedJSON = getJsonFileAsJsonObject("refund/partial_cc.json");

        JSONAssert.assertEquals(expectedJSON.toString(), refundJSON, false);

    }

    @Test
    public void testRefundRequestCreditCardFull() throws JSONException {
        RefundRequest refund = new RefundRequest("ORD-89SOQ6FMPJPX")
            .refundingInstrument(new RefundingInstrumentRequest().creditCard())
            .amount(2000);
        String refundJSON = new GsonFactory().gson().toJson(refund);
        JsonObject expectedJSON = getJsonFileAsJsonObject("refund/full_cc.json");

        JSONAssert.assertEquals(expectedJSON.toString(), refundJSON, false);

    }

    @Test
    public void testRefundRequestBankAccountFull() throws JSONException {
        RefundRequest refund = new RefundRequest("PAY-K6GFREQDHVV8")
            .refundingInstrument(new RefundingInstrumentRequest()
                .bankAccount(
                    new BankAccountRequest()
                        .checking()
                        .bankNumber("001")
                        .accountNumber("1234")
                        .accountCheckNumber("1")
                        .agencyNumber("4444444")
                        .agencyCheckNumber("2")
                        .holder(new HolderRequest()
                            .fullname("Nome do Portador")
                            .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                        )
                )
            );
        String refundJSON = new GsonFactory().gson().toJson(refund);
        JsonObject expectedJSON = getJsonFileAsJsonObject("refund/full_bank_account.json");

        JSONAssert.assertEquals(expectedJSON.toString(), refundJSON, false);
    }

    @Test
    public void testRefundRequestBankAccountPartial() throws JSONException {
        RefundRequest refund = new RefundRequest("PAY-E4Q0N9TK0BFW")
            .refundingInstrument(new RefundingInstrumentRequest()
                .bankAccount(
                    new BankAccountRequest()
                        .checking()
                        .bankNumber("001")
                        .accountNumber("1234")
                        .accountCheckNumber("1")
                        .agencyNumber("4444444")
                        .agencyCheckNumber("2")
                        .holder(new HolderRequest()
                            .fullname("Nome do Portador")
                            .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                        )
                )
            )
            .amount(10000);
        String refundJSON = new GsonFactory().gson().toJson(refund);
        JsonObject expectedJSON = getJsonFileAsJsonObject("refund/partial_bank_account.json");

        JSONAssert.assertEquals(expectedJSON.toString(), refundJSON, false);
    }
}
