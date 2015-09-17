package br.com.moip;

import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;
import br.com.moip.resource.structure.Address;
import br.com.moip.resource.structure.CreditCard;
import br.com.moip.resource.structure.Holder;
import br.com.moip.resource.structure.Phone;
import br.com.moip.resource.structure.TaxDocument;
import com.rodrigosaito.mockwebserver.player.Play;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class MoipOrdersTest extends AbstractMoipTest {

    @Test
    @Play("order_response")
    public void testCreateOrder() {
        Order createdOrder = moip.orders()
                .setOwnId("java_sdk_1")
                .addItem("Nome do produto", 1, "Mais info...", 1000)
                .setShippingAmount(100)
                .setCustomer(
                        moip.customers()
                                .setOwnId("java_sdk_customer_1")
                                .setFullname("Jose da Silva")
                                .setEmail("sandbox_v2_1401147277@email.com")
                                .setBirthDate("1988-12-30")
                                .setTaxDocument("33333333333")
                                .setPhone("11", "66778899", "55")
                                .setShippingAddress(
                                        new Address()
                                                .setStreet("Avenida Faria Lima")
                                                .setStreetNumber("2927")
                                                .setComplement("8")
                                                .setDistrict("Itaim")
                                                .setCity("São Paulo")
                                                .setState("SP")
                                                .setZipCode("01234000")
                                )
                )
                .create();

        assertThat(createdOrder.getId(), startsWith("ORD-"));
        assertThat(createdOrder.getStatus(), equalTo("CREATED"));
    }

    // TODO FIXME
    public void testCreateOrderMinimun() {
        Order createdOrder = moip.orders()
                .setOwnId("cooking_store-12345")
                .addItem("Methylamine - 1 Barrel", 1, "The best ingredient for Blue Sky", 1000)
                .setShippingAmount(100)
                .setCustomer(
                        moip.customers()
                                .setOwnId("walter-123")
                                .setFullname("Walter White")
                                .setEmail("walter@white.com")
                )
                .create();

        Payment createdPayment = createdOrder.payments()
                .setInstallmentCount(1)
                .setCreditCard(
                        new CreditCard()
                                .setNumber("4024007199037499")
                                .setCvc("123")
                                .setExpirationMonth("12")
                                .setExpirationYear("20")
                                .setHolder(
                                        new Holder()
                                                .setFullname("Walter White")
                                                .setBirthdate("1959-08-07")
                                                .setPhone(
                                                        new Phone()
                                                                .setAreaCode("11")
                                                                .setNumber("66778899")
                                                )
                                                .setTaxDocument(TaxDocument.cpf("22222222222"))
                                )
                )
                .execute();

    }

    @Test
    @Play("order_response")
    public void testGetOrder() {
        Order order = moip.orders().get("ORD-JY95N80TXHXV");

        assertThat(order.getId(), equalTo("ORD-JY95N80TXHXV"));
    }

    @Test (expected = MoipException.class)
    @Play("order_response_error")
    public void deveLancarExceptionCasoOcorraErroInesperado(){
        Order createdOrder = moip.orders()
                .setOwnId("java_sdk_1")
                .addItem("Nome do produto", 1, "Mais info...", 1000)
                .setShippingAmount(100)
                .setCustomer(
                        moip.customers()
                                .setOwnId("nrgbyb")
                                .setFullname("Jose da Silva")
                                .setEmail("sandbox_v2_1401147277@email.com")
                                .setBirthDate("1988-12-30")
                                .setTaxDocument("333333333333333333")
                                .setPhone("11", "66778899", "55")
                                .setShippingAddress(
                                        new Address()
                                                .setStreet("Avenida Faria Lima")
                                                .setStreetNumber("2927")
                                                .setComplement("8")
                                                .setDistrict("Itaim")
                                                .setCity("São Paulo")
                                                .setState("SP")
                                                .setZipCode("01234000")
                                )
                )
                .create();
    }

    @Test
    @Play("order_response_validation_error")
    public void deveEnviarExceptionCasoOcorraErroValidacao(){
        try {
            Order createdOrder = moip.orders()
                    .setOwnId("java_sdk_1")
                    .addItem("Nome do produto", 0, "Mais info...", 1000)
                    .setShippingAmount(100)
                    .setCustomer(
                            moip.customers()
                                    .setOwnId("java_sdk_customer_1")
                                    .setFullname("Jose da Silva")
                                    .setEmail("sandbox_v2_1401147277@email.com")
                                    .setBirthDate("1988-12-30")
                                    .setTaxDocument("33333333333")
                                    .setPhone("11", "66778899", "55")
                                    .setShippingAddress(
                                            new Address()
                                                    .setStreet("Avenida Faria Lima")
                                                    .setStreetNumber("2927")
                                                    .setComplement("8")
                                                    .setDistrict("Itaim")
                                                    .setCity("São Paulo")
                                                    .setState("SP")
                                                    .setZipCode("01234000")
                                    )
                    )
                    .create();
        }catch (ValidationException v){
            Assert.assertEquals("deve estar entre 1 e 9999" ,v.getErrors().get(0).getDescription());
            Assert.assertEquals("items[0].quantity", v.getErrors().get(0).getPath());
        }
    }
}