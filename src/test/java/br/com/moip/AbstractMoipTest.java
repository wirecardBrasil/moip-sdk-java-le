package br.com.moip;

import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;

public abstract class AbstractMoipTest {

    protected Moip moip;

    @Rule
    public Player apiMock = new Player();

    @Before
    public void aSetUp() {
        String token = "0ERVDN386WE3RZRI4YYG6QCDLMJ57LBR";
        String key = "SRZGHRXYOT0PVDLRB3YE8XQWLNLA0JRXTKOIDVDQ";
        Authentication moipBasic = new BasicAuth(token, key);

//        moip = new Moip(moipBasic, Moip.SANDBOX_ENDPOINT);
        moip = new Moip(moipBasic, apiMock.getURL("/").toString());
    }
}
