//Namespace
package com.microservice.conversation.controller.handler;

//Imports

import com.microservice.conversation.domain.message.ErrorMessage;
import com.microservice.conversation.exception.DatabaseException;
import com.microservice.conversation.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class that handles the common exceptions of all controllers
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * Database exception handler
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    ErrorMessage handleDatabaseException(DatabaseException e) {
        //Create the message
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(e.getMessage());
        errorMessage.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        //Return the message
        return errorMessage;
    }


    /**
     * ResourceNotFoundException handler
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ErrorMessage handleResourceNotFoundException(ResourceNotFoundException e) {
        //Create the message
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(e.getMessage());
        errorMessage.setStatus(HttpStatus.NOT_FOUND);

        //Return the message
        return errorMessage;
    }



}
