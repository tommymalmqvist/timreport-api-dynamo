package se.codelabs.timereport.api.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@DynamoDBTable(tableName = "Event")
public class Event implements Serializable {

    private static final long serialVersionUID = 10L;

    @Id
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
//        this.eventId.setEventDate(eventDate);
//        this.eventId.setUserId(userId);
        this.reason = reason;
        this.eventDate = eventDate;
        this.hours = hours;
    }

    @DynamoDBHashKey(attributeName = "userid")
    public String getUserId() {
        return eventId != null ? eventId.getUserId() : null;
    }
    public void setUserId(String userId) {
        if(eventId == null) eventId = new EventId();
        eventId.setUserId(userId);
    }


    @DynamoDBRangeKey(attributeName = "eventdate")
    public String getEventDate() {
        return eventId != null ? eventId.getEventDate() : null;
    }

    public void setEventDate(String eventDate) {
        if(eventId == null) eventId = new EventId();
        eventId.setEventDate(eventDate);
    }


    @DynamoDBAttribute(attributeName = "username")
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
