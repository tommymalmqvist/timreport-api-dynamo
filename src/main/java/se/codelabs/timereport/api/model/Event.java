package se.codelabs.timereport.api.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


@DynamoDBTable(tableName = "Event")
@DynamoDBDocument
public class Event implements Serializable {

    private static final long serialVersionUID = 10L;

    @Id
    private EventId eventId;

    private String userId;
    private String eventDate;
    private String name;
    private int hours;
    private String reason;


    public Event() { }

//    public Event(String userId, String userName, String reason, String eventDate, int hours) {
//        this.userId = userId;
//        this.userName = userName;
//        this.reason = reason;
//        this.eventDate = eventDate;
//        this.hours = hours;
//    }

    @DynamoDBHashKey(attributeName = "userid")
    public String getUserid() {
        return eventId != null ? eventId.getUserId() : null;
    }
    public void setUserid(String userId) {
        if(eventId == null) eventId = new EventId();
        eventId.setUserId(userId);
        this.userId = userId;
    }


    @DynamoDBRangeKey(attributeName = "date")
    public String getDate() {
        return eventId != null ? eventId.getEventDate() : null;
    }

    public void setDate(String eventDate) {
        if(eventId == null) eventId = new EventId();
        eventId.setEventDate(eventDate);
        this.eventDate = eventDate;
    }


    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
