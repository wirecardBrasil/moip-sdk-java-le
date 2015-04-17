package br.com.moip;

import br.com.moip.resource.Order;
import br.com.moip.resource.structure.Address;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class MoipTest {

    private Moip moip;

    @Rule
    public Player apiMock = new Player();

    @Before
    public void setUp() {
        String token = "0ERVDN386WE3RZRI4YYG6QCDLMJ57LBR";
        String key = "SRZGHRXYOT0PVDLRB3YE8XQWLNLA0JRXTKOIDVDQ";
        Authentication moipBasic = new BasicAuth(token, key);

//        moip = new Moip(moipBasic, Moip.SANDBOX_ENDPOINT);
        moip = new Moip(moipBasic, apiMock.getURL("/").toString());
    }

    @Test
    @Play("create_order")
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
}