
//Namespace
package com.microservice.conversation.exception;

/**
 * Class that represents a ResourceNotFoundException
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
