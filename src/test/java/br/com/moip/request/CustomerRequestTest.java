package br.com.moip.request;

import br.com.moip.util.GsonFactory;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class CustomerRequestTest extends RequestTest {

    @Test
    public void testAddCreditCard() throws JSONException {
        CustomerRequest customer = new CustomerRequest()
            .fundingInstrument(
                new FundingInstrumentRequest()
                    .creditCard(
                        new CreditCardRequest()
                            .number("4012001037141112")
                            .cvc(123)
                            .expirationMonth("05")
                            .expirationYear("18")
                            .holder(
                                new HolderRequest()
                                    .fullname("Jose Portador da Silva")
                                    .birthdate("1988-10-10")
                                    .phone(
                                        new PhoneRequest()
                                            .setAreaCode("11")
                                            .setNumber("55667788")
                                    )
                                    .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                            )
                    )
            );

        String json = new GsonFactory().gson().toJson(customer.getFundingInstrument());
        JsonObject expectedJSON = getJsonFileAsJsonObject("customer/add_credit_card.json");

        JSONAssert.assertEquals(expectedJSON.toString(), json, true);
    }
}
