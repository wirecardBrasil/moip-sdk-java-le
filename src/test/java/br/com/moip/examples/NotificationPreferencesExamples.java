package br.com.moip.examples;

import br.com.moip.API;
import br.com.moip.examples.setup.Setup;
import br.com.moip.request.NotificationPreferenceRequest;
import br.com.moip.response.NotificationPreferenceListResponse;
import br.com.moip.resource.NotificationPreference;
import org.junit.Test;

public class NotificationPreferencesExamples {

    /**
     * Webhooks are the notifications sent by Moip to your system
     * every time your transaction has its status changed. So,
     * through webhooks, is possible to synchronize your application
     * with Moip.
     *
     * Read more about notification preferences on:
     * https://dev.moip.com.br/v2/reference#1-notifica%C3%A7%C3%B5es-mp
     * https://dev.moip.com.br/v2.0/docs/webhook
     */

    // API instance
    API api = new Setup().buildSetup();

    /*
     * To receive webhooks you should create a notification preference.
     * TIP: at this moment, you can register one or more URLs to receive webhooks.
     */
    public void createNotificationPreference() {

        NotificationPreference notificationPreference = api.notification().create(new NotificationPreferenceRequest()
            .addEvent("ORDER.*")
            .addEvent("PAYMENT.AUTHORIZED")
            .addEvent("PAYMENT.CANCELLED")
            .target("http://requestb.in/1dhjesw1")
        );
    }

    // This method allows you to get a notification preference.
    public void getNotificationPreference() {

        NotificationPreference notificationPreference = api.notification().get("NPR-Y1LED31XHNU8");
    }

    // This methods list all created notification preferences.
    public void listNotificationPreference() {

        NotificationPreferenceListResponse notificationList = api.notification().list();
    }

    // This method allows you to delete a notification preference.
    public void deleteNotificationPreference() {

        api.notification().delete("NPR-Y1LED31XHNU8");
    }
}
