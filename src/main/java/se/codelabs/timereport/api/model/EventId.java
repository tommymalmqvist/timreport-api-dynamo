package se.codelabs.timereport.api.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import java.io.Serializable;

public class EventId implements Serializable {
    private static final long serialVersionUID = 10L;

    @DynamoDBHashKey(attributeName = "userid")
    private String id;

    @DynamoDBRangeKey(attributeName = "eventdate")
    private String date;

    public EventId() {}

    public EventId(String id, String date) {
        this.id = id;
        this.date = date;
    }

    public String getUserId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
    }

    public String getEventDate() {
        return date;
    }

    public void setEventDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventId eventId = (EventId) o;
        if (!getUserId().equals(eventId.getUserId())) return false;
        return getEventDate().equals(eventId.getEventDate());
    }

    @Override
    public int hashCode() {
        int result = getUserId().hashCode();
        result = 31 * result + getEventDate().hashCode();
        return result;
    }
}
