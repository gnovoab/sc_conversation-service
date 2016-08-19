
//Namespace
package com.microservice.conversation.exception;

/**
 * Class that represents an exception on database
 */
public class DatabaseException extends RuntimeException {

	/**
	 * Constructor
	 * @param message
	 * @param cause
	 */
	public DatabaseException(String message, Throwable cause) {
		super(message, cause);
	}
}
