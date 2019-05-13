package com.grupo.msc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceExceptionBadRequest extends RuntimeException{

	public ResourceExceptionBadRequest(String message) {
		super(message);
	}
	
}
