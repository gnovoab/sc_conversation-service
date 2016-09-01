//Namespace
package com.microservice.conversation.controller.handler;

//Imports

import com.microservice.conversation.domain.ApiMessageResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles that handles common exceptions of all controllers
 */
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //Fields
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
        String error;
        for (FieldError fieldError : fieldErrors) {
            error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
            errors.add(error);
        }
        for (ObjectError objectError : globalErrors) {
            error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
            errors.add(error);
        }

        ApiMessageResponse apiResponse = new ApiMessageResponse(HttpStatus.BAD_REQUEST, "Invalid Payload");
        apiResponse.setFieldErrors(errors);

        return new ResponseEntity<>(apiResponse, headers, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers,
                                                                     HttpStatus status, WebRequest request) {
        String unsupported = "Unsupported content type: " + ex.getContentType();
        String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());

        ApiMessageResponse apiResponse = new ApiMessageResponse(status, unsupported + ".\n" + supported);
        return new ResponseEntity<>(apiResponse, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        ApiMessageResponse apiResponse = new ApiMessageResponse(status, ex.getMessage());
        if (mostSpecificCause != null) {
            apiResponse.setMessage(mostSpecificCause.getMessage());
            apiResponse.setMoreInfo("Exception name: " + mostSpecificCause.getClass().getName());

        }
        return new ResponseEntity<>(apiResponse, headers, status);
    }

}