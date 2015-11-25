package br.com.moip.api;

import br.com.moip.request.CustomerRequest;
import br.com.moip.request.OrderRequest;
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
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new OrderAPI(clientFactory.client(player.getURL("").toString()));
//        api = new OrderAPI(clientFactory.client(Client.SANDBOX));
    }

    @Play("orders/create")
    @Test
    public void testCreate() {
        Order createdOrder = api.create(new OrderRequest()
                        .ownId("order_own_id")
                        .addItem("Nome do produto", 1, "Mais info...", 100)
                        .customer(new CustomerRequest()
                                        .ownId("customer_own_id")
                                        .fullname("Jose da Silva")
                                        .email("sandbox_v2_1401147277@email.com")
                        )
        );

        assertEquals("ORD-HCOWQ2QJKTAT", createdOrder.getId());
    }
}