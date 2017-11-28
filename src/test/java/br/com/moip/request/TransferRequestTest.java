package br.com.moip.request;

import br.com.moip.util.GsonFactory;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TransferRequestTest extends RequestTest{

    @Test
    public void testCreateTransfer() throws JSONException {
        TransferRequest transfer = new TransferRequest()
            .amount(500)
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
            );

        String json = new GsonFactory().gson().toJson(transfer);
        JsonObject expectedJSON = getJsonFileAsJsonObject("transfer/create.json");

        JSONAssert.assertEquals(expectedJSON.toString(), json, true);
    }
}
