
//Namespace
package com.microservice.conversation.domain;

//Imports
import org.hibernate.validator.constraints.NotBlank;

/**
 * Class that represents the payload forconversation
 */
public class Conversation {

    //Fields
    @NotBlank private String sessionId;
    @NotBlank private String userQuestion;
    @NotBlank private String botResponse;


    //Getters and Setters
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
}
