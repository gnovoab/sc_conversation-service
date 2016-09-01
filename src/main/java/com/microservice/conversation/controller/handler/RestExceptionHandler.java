//Namespace
package com.microservice.conversation.controller.handler;

//Imports

import com.microservice.conversation.domain.ApiMessageResponse;
import com.microservice.conversation.exception.DatabaseException;
import com.microservice.conversation.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Class that handles the common exceptions of all controllers
 */
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * Database exception handler
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = {DatabaseException.class})
    public ResponseEntity<ApiMessageResponse> handleDatabaseException(DatabaseException e, WebRequest request) {
        //Create message
        ApiMessageResponse apiResponse = new ApiMessageResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

        //Return message
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    /**
     * ResourceNotFoundException handler
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ApiMessageResponse> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        ApiMessageResponse apiResponse = new ApiMessageResponse(HttpStatus.NOT_FOUND, e.getMessage());

        //Return message
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

    }
}
