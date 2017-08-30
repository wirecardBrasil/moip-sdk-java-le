package br.com.moip.api;

import br.com.moip.Client;
import br.com.moip.request.NotificationPreferenceRequest;
import br.com.moip.resource.NotificationPreference;

public class NotificationPreferencesAPI {

    private Client client;

    public NotificationPreferencesAPI(final Client client) {
        this.client = client;
    }

    public NotificationPreference create(final NotificationPreferenceRequest notificationPreference) {
        return client.post("/v2/preferences/notifications", notificationPreference, NotificationPreference.class);
    }

    public NotificationPreference get(final String notificationId) {
        return client.get("/v2/preferences/notifications/" + notificationId, NotificationPreference.class);
    }
}
