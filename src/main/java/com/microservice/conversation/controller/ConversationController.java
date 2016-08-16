
//Namespace
package com.microservice.conversation.controller;

//Imports
import com.microservice.conversation.domain.Conversation;
import com.microservice.conversation.domain.message.Message;
import com.microservice.conversation.domain.message.SuccessMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Class that represents the conversation endpoint
 */
@Api(description = "Endpoint for bot conversation")
@RestController
@RequestMapping("/rest/v1/bot/{botId}/conversation")
public class ConversationController {


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns success message", response = Message.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "The service encountered a problem.")
    })
    public ResponseEntity<Message> saveConversation(@PathVariable("botId") String botId,
                                                    @RequestBody @Valid Conversation conversation) {

        //Create message
        Message message = new SuccessMessage(HttpStatus.CREATED, "conversation saved successfully");

        //Return message
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }


}
