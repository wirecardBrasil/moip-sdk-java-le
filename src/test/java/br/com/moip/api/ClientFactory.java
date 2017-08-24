package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.authentication.BasicAuth;

public class ClientFactory {

    public Client client(final String endpoint) {
        return new Client(
                endpoint,
                new BasicAuth("01010101010101010101010101010101", "ABABABABABABABABABABABABABABABABABABABAB")
        );
    }
}
