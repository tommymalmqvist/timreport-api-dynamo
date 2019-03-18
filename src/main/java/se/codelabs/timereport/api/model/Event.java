package se.codelabs.timereport.api.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@DynamoDBTable(tableName = "Event")
public class Event implements Serializable {

    private static final long serialVersionUID = 10L;

    @Id
    @DynamoDBIgnore
    private EventId eventId;

    @NotNull
    private String userId;
    private String eventDate;

    private String userName;
    private String reason;
    private int hours;


    public Event() { }

    public Event(String userId, String userName, String reason, String eventDate, int hours) {
        this.userId = userId;
        this.userName = userName;
        this.reason = reason;
        this.eventDate = eventDate;
        this.hours = hours;
    }

    @DynamoDBHashKey(attributeName = "user_id")
    public String getUserId() {
        return eventId != null ? eventId.getUserId() : null;
    }
    public void setUserId(String userId) {
        if(eventId == null) eventId = new EventId();
        eventId.setUserId(userId);
    }


    @DynamoDBRangeKey(attributeName = "event_date")
    public String getEventDate() {
        return eventId != null ? eventId.getEventDate() : null;
    }

    public void setEventDate(String eventDate) {
        if(eventId == null) eventId = new EventId();
        eventId.setEventDate(eventDate);
    }


    @DynamoDBAttribute(attributeName = "user_name")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DynamoDBAttribute(attributeName = "reason")
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    @DynamoDBAttribute(attributeName = "hours")
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }


}
