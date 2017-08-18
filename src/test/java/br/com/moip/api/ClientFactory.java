package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.authentication.BasicAuth;
import br.com.moip.authentication.OAuth;

public class ClientFactory {

    public Client client(final String endpoint) {
        return new Client(
                endpoint,
                //new BasicAuth("01010101010101010101010101010101", "ABABABABABABABABABABABABABABABABABABABAB")
                //new BasicAuth("GAN2LQACIQQFZVYPIV3PYFAXAGTLVV09", "QP5QD52JNG6POF3AURDUDNE7AXLAI0XDFMVGTGNF")
                new OAuth("e8b1063bfb5046ec80ad119f021e1b71_v2")
        );
    }
}
