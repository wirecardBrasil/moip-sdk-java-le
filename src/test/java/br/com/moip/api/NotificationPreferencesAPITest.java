package br.com.moip.api;

import br.com.moip.request.NotificationPreferenceRequest;
import br.com.moip.resource.NotificationPreference;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NotificationPreferencesAPITest {

    @Rule
    public Player player = new Player();

    private NotificationPreferencesAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new NotificationPreferencesAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Play("notification_preferences/create")
    @Test
    public void testCreateNotificationPreference() {
        NotificationPreference notificationPreference = api.create(
            new NotificationPreferenceRequest()
                .addEvent("ORDER.*")
                .addEvent("PAYMENT.AUTHORIZED")
                .addEvent("PAYMENT.CANCELLED")
                .target("http://requestb.in/1dhjesw1")
        );

        assertEquals("NPR-NR0GR85KHL10", notificationPreference.getId());
        assertEquals("ORDER.*", notificationPreference.getEvents().get(0));
        assertEquals("PAYMENT.CANCELLED", notificationPreference.getEvents().get(2));
        assertEquals("PAYMENT.AUTHORIZED", notificationPreference.getEvents().get(1));
        assertEquals("http://requestb.in/1dhjesw1", notificationPreference.getTarget());
        assertNotNull(notificationPreference.getToken());
    }

    @Play("notification_preferences/get")
    @Test
    public void testGetNotification() {
        NotificationPreference notificationPreference = api.get("NPR-NR0GR85KHL10");

        assertEquals("NPR-NR0GR85KHL10", notificationPreference.getId());
        assertEquals("ORDER.*", notificationPreference.getEvents().get(0));
        assertEquals("PAYMENT.AUTHORIZED", notificationPreference.getEvents().get(1));
        assertEquals("PAYMENT.CANCELLED", notificationPreference.getEvents().get(2));
        assertEquals("http://requestb.in/1dhjesw1", notificationPreference.getTarget());
        assertEquals("1465c36fce654c6186dd805eb8a8acb7", notificationPreference.getToken());
        assertNotNull(notificationPreference.getToken());
    }
}
