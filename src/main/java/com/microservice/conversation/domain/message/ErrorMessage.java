
//Namespace
package com.microservice.conversation.domain.message;


//Imports
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * The Class ErrorMessage.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage extends Message{

	//Fields
	private List<String> fieldErrors;
	private String errorKey;
	private String moreInfo;


	/**
	 * Instantiates a new error message.
     * @param created
     * @param message
     */
	public ErrorMessage(HttpStatus created, String message){}


	//Getters and Setters

	public List<String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
}
