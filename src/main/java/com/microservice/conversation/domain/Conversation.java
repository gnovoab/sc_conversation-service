
//Namespace
package com.microservice.conversation.domain;

//Imports

import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * Class that represents the payload forconversation
 */
@ApiModel
@Entity
@Table(name = "gb_conversation")
public class Conversation {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String botId;

    @NotBlank
    private String userId;
    @NotBlank
    private String sessionId;
    @NotBlank
    private String userQuestion;
    @NotBlank
    private String botResponse;

    private Date timestamp;

    public Conversation() {
        timestamp = new Date();
    }

    //Getters and Setters


    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getBotResponse() {
        return botResponse;
    }

    public void setBotResponse(String botResponse) {
        this.botResponse = botResponse;
    }

    public Date getTimestamp() {
        return (Date) timestamp.clone();
    }


    @PrePersist
    public void onPrePersist() {
        timestamp = new Date();
    }
}
