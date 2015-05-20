package br.com.moip;

import br.com.moip.resource.Order;
import br.com.moip.resource.structure.Address;
import com.rodrigosaito.mockwebserver.player.Play;
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

    @Test
    @Play("order_response")
    public void testGetOrder() {
        Order order = moip.orders().get("ORD-JY95N80TXHXV");

        assertThat(order.getId(), equalTo("ORD-JY95N80TXHXV"));
    }
}