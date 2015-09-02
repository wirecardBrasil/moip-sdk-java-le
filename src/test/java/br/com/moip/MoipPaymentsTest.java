package br.com.moip;

import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;
import br.com.moip.resource.structure.Boleto;
import br.com.moip.resource.structure.CreditCard;
import br.com.moip.resource.structure.Holder;
import br.com.moip.resource.structure.Phone;
import br.com.moip.resource.structure.TaxDocument;
import com.rodrigosaito.mockwebserver.player.Play;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class MoipPaymentsTest extends AbstractMoipTest {

    @Test
    @Play( { "order_response", "payment_credit_card_response" })
    public void testCreatePaymentCreditCard() {
        Order order = moip.orders().get("ORD-JY95N80TXHXV");

        Payment createdPayment = order.payments()
                .setInstallmentCount(1)
                .setCreditCard(
                        new CreditCard()
                                .setNumber("4012001038443335")
                                .setCvc("123")
                                .setExpirationMonth("04")
                                .setExpirationYear("18")
                                .setHolder(
                                        new Holder()
                                                .setFullname("Jose Portador da Silva")
                                                .setBirthdate("1988-10-10")
                                                .setPhone(
                                                        new Phone()
                                                                .setAreaCode("11")
                                                                .setNumber("55667788")
                                                )
                                                .setTaxDocument(TaxDocument.cpf("22222222222"))
                                )
                )
                .execute();

        assertThat(createdPayment.getId(), startsWith("PAY-"));
        assertThat(createdPayment.getStatus(), equalTo("IN_ANALYSIS"));
    }

    @Test
    @Play( { "order_response", "payment_credit_card_response" })
    public void testCreatePaymentCreditCardHash() {
        Order order = moip.orders().get("ORD-XDH04PIVWOVR");

        Payment createdPayment = order.payments()
                .setInstallmentCount(1)
                .setCreditCard(
                        new CreditCard()
                                .setHash("JARQtjm/AJN4s6W00V2IZ+xHTW8zFNu1mWyW3RR21Z05h0LFSFLRH8yumqaktPXU49Ku/InBPCM+l85NYsNJiPD7BjybOW1g6HPZEjpz7krUtvHh4gqXRlLxL66D7Uf5CQ5dFeeyb6OgSoDpYBDlbhtpuSBTqYKHdHSK7xMebnPZvLamKiLFa/TVbUno9qAkLTB4NXdfcSzlq0YbgpEaUHA9oRaiH/n0Vt/NJDVQsb+SxeiJnO9WFzzC5adcSPn5p821uRFcyvykA3LloqbKhQemDghuP51bb0vuRQtmq6YKqT8eYc3DTlrlB8J2tX4PBplFCu1FyWSpeaiWB33zUg==")
                                .setHolder(
                                        new Holder()
                                                .setFullname("Jose Portador da Silva")
                                                .setBirthdate("1988-10-10")
                                                .setPhone(
                                                        new Phone()
                                                                .setAreaCode("11")
                                                                .setNumber("55667788")
                                                )
                                                .setTaxDocument(TaxDocument.cpf("22222222222"))
                                )
                )
                .execute();


    }

    @Test
    @Play( { "order_response", "payment_boleto_response" })
    public void testCreatePaymentBoleto() {
        Order order = moip.orders().get("ORD-FWR7V5ZC0414");

        Payment createdPayment = order.payments()
                .setBoleto(
                        new Boleto()
                                .setExpirationDate("2015-09-30")
                                .setLogoUri("https://")
                                .setFirstInstructionLine("Primeira linha do boleto")
                                .setSecondInstructionLine("Segunda linha do boleto")
                                .setThirdInstructionLine("Terceira linha do boleto")
                )
                .execute();

        assertThat(createdPayment.getId(), startsWith("PAY-"));
        assertThat(createdPayment.getStatus(), equalTo("WAITING"));
        assertThat(createdPayment.get_links().getOrder().getTitle(), equalTo("ORD-FWR7V5ZC0414"));
        assertThat(createdPayment.get_links().getOrder().getHref(), equalTo("https://test.moip.com.br/v2/orders/ORD-FWR7V5ZC0414"));
        assertThat(createdPayment.get_links().getPayBoleto().getRedirectHref(), equalTo("https://checkout-sandbox.moip.com.br/boleto/PAY-1I98L665B5U8"));
    }
}
