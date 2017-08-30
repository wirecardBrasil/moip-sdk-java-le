package br.com.moip.api;

import br.com.moip.request.NotificationPreferenceRequest;
import br.com.moip.resource.NotificationPreference;
import br.com.moip.response.NotificationPreferenceListResponse;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Play("notification_preferences/delete")
    @Test
    public void testDeleteNotification() {
        assertTrue(api.delete("NPR-NR0GR85KHL10"));
    }

    @Play("notification_preferences/delete")
    @Test
    public void testDeleteNotificationDeleted() {
        assertFalse(api.delete("NPR-CQU74AQOIVCV"));
    }

    @Play("notification_preferences/list")
    @Test
    public void testListNotificationPreferences() {
        NotificationPreferenceListResponse notificationPreferenceList = api.list();

        assertEquals("NPR-KINZC2J1C3LJ", notificationPreferenceList.get(0).getId());
        assertEquals("NPR-LCUIYBWHN87X", notificationPreferenceList.get(5).getId());
    }

}
