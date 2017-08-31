package br.com.moip.request;

import br.com.moip.util.GsonFactory;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class NotificationPreferenceRequestTest extends RequestTest {

    @Test
    public void testCreateNotificationPreference() throws JSONException {
        NotificationPreferenceRequest notificationPreference = new NotificationPreferenceRequest()
                .addEvent("ORDER.*")
                .addEvent("PAYMENT.AUTHORIZED")
                .addEvent("PAYMENT.CANCELLED")
                .target("http://requestb.in/1dhjesw1");

        String notificationPreferenceJSON = new GsonFactory().gson().toJson(notificationPreference);
        JsonObject expectedJSON = getJsonFileAsJsonObject("notification_preferences/create.json");

        JSONAssert.assertEquals(expectedJSON.toString(), notificationPreferenceJSON, true);
    }
}
