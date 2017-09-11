package br.com.moip.resource;

import java.util.Date;

public class Event {

    private Date createdAt;
    private String type;
    private String description;

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return new StringBuilder("Event{")
            .append("createdAt=").append(createdAt)
            .append(", type='").append(type).append('\'')
            .append(", description='").append(description).append('\'')
            .append("}").toString();
    }
}
