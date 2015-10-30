package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.authentication.BasicAuth;
import br.com.moip.resource.Customer;
import br.com.moip.resource.Order;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderAPITest {

    @Rule
    public Player player = new Player();

    private OrderAPI api;

    @Before
    public void setup() {
        api = new OrderAPI(new Client(player.getURL("").toString(), new BasicAuth("01010101010101010101010101010101", "ABABABABABABABABABABABABABABABABABABABAB")));
//        api = new OrderAPI(new Client(Client.SANDBOX, new BasicAuth("01010101010101010101010101010101", "ABABABABABABABABABABABABABABABABABABABAB")));
    }

    @Play("orders/create")
    @Test
    public void testCreate() {
        Order createdOrder = api.create(new Order()
                        .setOwnId("order_own_id")
                        .addItem("Nome do produto", 1, "Mais info...", 100)
                        .setCustomer(new Customer()
                                        .setOwnId("customer_own_id")
                                        .setFullname("Jose da Silva")
                                        .setEmail("sandbox_v2_1401147277@email.com")
                        )
        );

        assertEquals("ORD-HCOWQ2QJKTAT", createdOrder.getId());
    }
}