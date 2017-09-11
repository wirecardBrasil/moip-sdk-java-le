package br.com.moip.util;

import br.com.moip.request.RequestTest;
import org.junit.Test;

import static br.com.moip.util.DataHelper.jsonToUrlEncodedString;
import static org.junit.Assert.assertEquals;

public class DataHelperTest extends RequestTest{

    @Test
    public void testJsonToFormEncoded() {
        String expected = "client_id=APP-XT5FIAK2F8I7&client_secret=e2bd3951b87e469eb0f2c2b781a753d5&code=8870af1372ada7a18fdff4fa4ca1a60f4d542272&redirect_uri=http%3A%2F%2Flocalhost%2Ftest-moip-sdk-php%2Fcallback.php";

        assertEquals(expected, jsonToUrlEncodedString(getJsonFileAsJsonObject("connect/generate_token.json")));
    }

    @Test
    public void testJsonToFormEncodedWithSubObject() {
        String expected = "orderId=ORD-GOHHIF4Z6PLV&installmentCount=1&fundingInstrument[method]=BOLETO&fundingInstrument[boleto][expirationDate]=2020-11-10&fundingInstrument[boleto][instructionLines][first]=Primeira+linha&fundingInstrument[boleto][instructionLines][second]=Segunda+linha&fundingInstrument[boleto][instructionLines][third]=Terceira+linha&fundingInstrument[boleto][logoUri]=http%3A%2F%2Flogo.com&fundingInstrument[suppressBoleto]=false&fundingInstrument[suppressCreditCard]=false";

        assertEquals(expected, jsonToUrlEncodedString(getJsonFileAsJsonObject("payment/create_boleto.json")));
    }
}
