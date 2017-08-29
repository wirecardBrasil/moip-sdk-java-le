package br.com.moip.request;

import java.util.ArrayList;
import java.util.List;

public class NotificationPreferenceRequest {

    private List<String> events = new ArrayList<String>();
    private String target;
    private final String media = "WEBHOOK";

    public NotificationPreferenceRequest addEvent(String event) {
        events.add(event);

        return this;
    }

    public List<String> getEvents() {
        return events;
    }

    public NotificationPreferenceRequest target(String target) {
        this.target = target;

        return this;
    }

    public String getTarget() {
        return target;
    }

    public String getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return new StringBuilder("NotificationPreferenceRequest{")
            .append("events=").append(events)
            .append("target='").append(target).append('\'')
            .append("media'=").append(media).append('\'')
            .append("}").toString();
    }
}
