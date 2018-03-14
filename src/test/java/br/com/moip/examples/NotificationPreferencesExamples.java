package br.com.moip.examples;

import br.com.moip.API;
import br.com.moip.examples.setup.Setup;
import br.com.moip.request.NotificationPreferenceRequest;
import br.com.moip.response.NotificationPreferenceListResponse;
import br.com.moip.resource.NotificationPreference;
import org.junit.Test;

public class NotificationPreferencesExamples {

    // API instance
    API api = new Setup().buildSetup();

    // OKAY
    public void createNotificationPreference() {

        NotificationPreference notificationPreference = api.notification().create(new NotificationPreferenceRequest()
            .addEvent("ORDER.*")
            .addEvent("PAYMENT.AUTHORIZED")
            .addEvent("PAYMENT.CANCELLED")
            .target("http://requestb.in/1dhjesw1")
        );
    }

    // OKAY
    public void getNotificationPreference() {

        NotificationPreference notificationPreference = api.notification().get("NPR-Y1LED31XHNU8");
    }

    // OKAY
    public void listNotificationPreference() {

        NotificationPreferenceListResponse notificationList = api.notification().list();
    }

    // OKAY
    public void deleteNotificationPreference() {

        api.notification().delete("NPR-Y1LED31XHNU8");
    }
}
