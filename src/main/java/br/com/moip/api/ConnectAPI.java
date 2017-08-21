package br.com.moip.api;

import br.com.moip.Client;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import br.com.moip.exception.MoipException;
import br.com.moip.resource.ScopePermissionList;
import org.apache.http.client.utils.URIBuilder;

public class ConnectAPI {

    private final Client client;

    public ConnectAPI(final Client client) {
        this.client = client;
    }

    public String getAuthUrl(String clientId, String redirectUri, ScopePermissionList scope) {

        try {
            URIBuilder b = new URIBuilder(Client.CONNECT_SANDBOX + "/oauth/authorize");
            b.addParameter("response_type", "code");
            b.addParameter("client_id", clientId);
            b.addParameter("redirect_uri", redirectUri);
            b.addParameter("scope", scope.toString());

            URL url = b.build().toURL();

            return url.toString();
        } catch (URISyntaxException e) {
            throw new MoipException("Error trying to build URL: " + e.getMessage());
        } catch (MalformedURLException e) {
            throw new MoipException("Error trying to build URL: " + e.getMessage());
        }

    }
}
