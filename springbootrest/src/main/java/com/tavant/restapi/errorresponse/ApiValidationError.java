package com.tavant.restapi.errorresponse;

import java.io.Serializable;

import lombok.Data;

@Data
public class ApiValidationError extends ApiSubError implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String object;
	private String field;
	private Object rejectedValue;
	
	
	public ApiValidationError(String object, String field, Object rejectedValue, String message) {
		super();
		this.object = object;
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}

	private String message;
	
	public ApiValidationError(String object, String message) {
		this.object=object;
		this.message=message;
		
	}

}
