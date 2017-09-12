package br.com.moip.resource;

import java.util.ArrayList;
import java.util.List;

public class NotificationPreference {

    private List<String> events = new ArrayList<>();
    private String target;
    private String media;
    private String token;
    private String id;

    public List<String> getEvents() {
        return events;
    }

    public String getToken() {
        return token;
    }

    public String getTarget() {
        return target;
    }

    public String getMedia() {
        return media;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringBuilder("NotificationPreference {events=").append(events)
            .append(", target='").append(target).append('\'')
            .append(", media='").append(media).append('\'')
            .append(", token='").append(token).append('\'')
            .append(", id='").append(id).append('\'')
            .append("}").toString();
    }
}
