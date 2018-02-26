package br.com.moip.resource;

public class Event {

    private String createdAt;
    private String type;
    private String description;

    public String getCreatedAt() {
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
