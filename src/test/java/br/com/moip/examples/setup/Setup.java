package br.com.moip.examples.setup;

import br.com.moip.API;
import br.com.moip.Client;
import br.com.moip.authentication.Authentication;
import br.com.moip.authentication.OAuth;

public class Setup {

    // Authentications

    private final String basicToken = "01010101010101010101010101010101";
    private final String basicKey = "ABABABABABABABABABABABABABABABABABABABAB";
    private final String oauth = "8833c9eb036543b6b0acd685a76c9ead_v2";

    public API buildSetup() {

        // Set Authentication

        Authentication auth = new OAuth(oauth);

        // Set Client

        Client client = new Client(Client.SANDBOX, auth);

        // Instantiate API

        API api = new API(client);

        return api;
    }
}
