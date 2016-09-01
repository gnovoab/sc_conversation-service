
//Namesapce
package com.microservice.conversation.controller;

//Imports

import com.microservice.conversation.domain.ApiMessageResponse;
import com.microservice.conversation.domain.Conversation;
import com.microservice.conversation.factory.ConversationFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

//import org.springframework.boot.test.TestRestTemplate;


/**
 * Integration tests class
 */
@ActiveProfiles("local")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConversationControllerIT {

    //Fields
    private static final String baseUrl = "/rest/v1/bot";

    @Resource
    private TestRestTemplate restTemplate;


    /**
     * Method that saves a correct payload on DB
     * @throws Exception
     */
    @Test
    public void testSaveConversation() throws Exception {
        //Create payload
        Conversation conversation = ConversationFactory.getIntegrationConversation();

        //Set the headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        //Create the http request
        HttpEntity<?> request = new HttpEntity<>(conversation ,requestHeaders);

        //Invoke the API service
        ResponseEntity<ApiMessageResponse> response = restTemplate.exchange(baseUrl+"/"+conversation.getBotId()+"/conversation", HttpMethod.POST, request, ApiMessageResponse.class);

        //Verify
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());

    }


    /**
     * Method that tries saves an incorrect payload on DB
     * @throws Exception
     */
    @Test
    public void testSaveConversationWrong() throws Exception {
        //Create payload
        Conversation conversation = ConversationFactory.getIntegrationConversation();
        conversation.setUserQuestion(null);
        conversation.setBotResponse("");

        //Set the headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        //Create the http request
        HttpEntity<?> request = new HttpEntity<>(conversation ,requestHeaders);

        //Invoke the API service
        ResponseEntity<ApiMessageResponse> response = restTemplate.exchange(baseUrl+"/"+conversation.getBotId()+"/conversation", HttpMethod.POST, request, ApiMessageResponse.class);

        //Verify
        Assert.assertEquals(HttpStatus.BAD_REQUEST , response.getStatusCode());

    }
}
