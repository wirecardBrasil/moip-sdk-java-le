package br.com.moip.api;

import br.com.moip.resource.ScopePermission;
import br.com.moip.resource.ScopePermissionList;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConnectAPITest {

    @Rule
    public Player player = new Player();
    private ConnectAPI api;

    @Before
    public void setUp() {
        api = new ConnectAPI(new ClientFactory().client(player.getURL("").toString()));
    }

    @Test
    public void testGetAuthURL() {

        String authURL = api.getAuthUrl("APP-XT5FIAK2F8I7",
            "http://localhost/test-moip-sdk-php/callback.php",
            new ScopePermissionList(ScopePermission.DEFINE_PREFERENCES
                , ScopePermission.MANAGE_ACCOUNT_INFO
                , ScopePermission.RECEIVE_FUNDS
                , ScopePermission.REFUND
                , ScopePermission.RETRIEVE_FINANCIAL_INFO
                , ScopePermission.TRANSFER_FUNDS
            )
        );

        assertEquals("https://connect-sandbox.moip.com.br/oauth/authorize?response_type=code&client_id=APP-XT5FIAK2F8I7&redirect_uri=http%3A%2F%2Flocalhost%2Ftest-moip-sdk-php%2Fcallback.php&scope=DEFINE_PREFERENCES%2CMANAGE_ACCOUNT_INFO%2CRECEIVE_FUNDS%2CREFUND%2CRETRIEVE_FINANCIAL_INFO%2CTRANSFER_FUNDS", authURL);
    }
}
