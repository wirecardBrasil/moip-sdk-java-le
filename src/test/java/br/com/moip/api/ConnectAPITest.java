package br.com.moip.api;

import br.com.moip.request.ConnectRequest;
import br.com.moip.request.GrantType;
import br.com.moip.resource.Connect;
import br.com.moip.resource.ScopePermission;
import br.com.moip.resource.ScopePermissionList;
import com.rodrigosaito.mockwebserver.player.Play;
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
            "http://localhost/moip/callback.php",
            new ScopePermissionList(ScopePermission.DEFINE_PREFERENCES
                , ScopePermission.MANAGE_ACCOUNT_INFO
                , ScopePermission.RECEIVE_FUNDS
                , ScopePermission.REFUND
                , ScopePermission.RETRIEVE_FINANCIAL_INFO
                , ScopePermission.TRANSFER_FUNDS
            )
        );

        assertEquals("https://connect-sandbox.moip.com.br/oauth/authorize?response_type=code&client_id=APP-XT5FIAK2F8I7&redirect_uri=http%3A%2F%2Flocalhost%2Fmoip%2Fcallback.php&scope=DEFINE_PREFERENCES%2CMANAGE_ACCOUNT_INFO%2CRECEIVE_FUNDS%2CREFUND%2CRETRIEVE_FINANCIAL_INFO%2CTRANSFER_FUNDS", authURL);
    }

    @Play("connect/generate_token")
    @Test
    public void testGenerateTokenOAuth() {
        Connect connect = api.authorize(new ConnectRequest()
            .clientId("APP-XT5FIAK2F8I7")
            .clientSecret("e2bd3951b87e469eb0f2c2b781a753d5")
            .code("8870af1372ada7a18fdff4fa4ca1a60f4d542272")
            .redirectUri("http://localhost/test-moip-sdk-php/callback.php")
            .grantType(GrantType.authorization_code)
        );

        assertEquals("21e39345432346329ca7f4967473d55d_v2", connect.getAccessToken());
        assertEquals("c71dfab2b2824f5b80506ae6adfbdb5b_v2", connect.getRefreshToken());
        assertEquals("2027-08-22", connect.getExpiresIn().getFormatedDate());
    }

    @Play("connect/refresh_token")
    @Test
    public void testRefreshTokenOAuth() {
        Connect connect = api.authorize(new ConnectRequest()
            .refreshToken("80ca5fb244674117be068d2535ecbe2f_v2")
            .grantType(GrantType.refresh_token)
        );

        assertEquals("f1bb699fd8d54b72b71b1f71d05b2a89_v2", connect.getAccessToken());
        assertEquals("80ca5fb244674117be068d2535ecbe2f_v2", connect.getRefreshToken());
        assertEquals("2027-08-24", connect.getExpiresIn().getFormatedDate());
    }
}
