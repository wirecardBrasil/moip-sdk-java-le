package br.com.moip.request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PaymentRequestTest extends RequestTest {

    @Test
    public void testPaymentWithBoleto() throws JSONException {
        PaymentRequest payment = new PaymentRequest()
            .orderId("MOR-F2R675R1X97P")
            .fundingInstrument(new FundingInstrumentRequest()
                .boleto(new BoletoRequest()
                    .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2017, Calendar.SEPTEMBER, 30).getTime()))
                    .instructionLines(new InstructionLinesRequest()
                        .first("Primeira linha se instrução")
                        .second("Segunda linha se instrução")
                        .third("Terceira linha se instrução")
                    )
                    .logoUri("http://")
                )
            );

        String paymentJSON = new Gson().toJson(payment);
        JsonObject expectedJSON = getJsonFileAsJsonObject("payment/create_boleto.json");

        JSONAssert.assertEquals(expectedJSON.toString(), paymentJSON, false);
    }

    @Test
    public void testPaymentWithCreditCard() throws JSONException {
        PaymentRequest payment = new PaymentRequest()
            .orderId("ORD-HPMZSOM611M2")
            .installmentCount(1)
            .delayCapture(true)
            .fundingInstrument(
                new FundingInstrumentRequest()
                    .creditCard(
                        new CreditCardRequest()
                            .number("4012001037141112")
                            .expirationMonth("05")
                            .expirationYear("2018")
                            .cvc(123)
                            .store(true)
                            .holder(
                                new HolderRequest()
                                    .fullname("Jose Portador da Silva")
                                    .birthdate("1988-12-30")
                                    .phone(
                                        new PhoneRequest()
                                            .setAreaCode("11")
                                            .setNumber("55667788")
                                    )
                                    .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                            )
                    )
            )
            .escrow(new PaymentRequest.EscrowRequest("Teste"));


        String paymentJSON = new Gson().toJson(payment);
        JsonObject expectedJSON = getJsonFileAsJsonObject("payment/create_cc.json");

        JSONAssert.assertEquals(expectedJSON.toString(), paymentJSON, false);
    }

    @Test
    public void testPaymentWithOnlineDebit() throws JSONException {
        PaymentRequest payment = new PaymentRequest()
            .orderId("ORD-VN1DD41V9G45")
            .installmentCount(1)
            .fundingInstrument(
                new FundingInstrumentRequest()
                    .onlineBankDebit(new OnlineBankDebitRequest()
                        .bankNumber("341")
                        .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2020, Calendar.AUGUST, 10).getTime()))
                        .returnUri("https://moip.com.br/")
                    )
            );

        String paymentJSON = new Gson().toJson(payment);
        JsonObject expectedJSON = getJsonFileAsJsonObject("payment/create_online_debit.json");

        JSONAssert.assertEquals(expectedJSON.toString(), paymentJSON, false);
    }
}
