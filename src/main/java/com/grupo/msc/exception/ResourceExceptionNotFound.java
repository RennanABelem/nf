package com.grupo.msc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceExceptionNotFound extends RuntimeException{
	
	public ResourceExceptionNotFound(String message) {
		super(message);
	}

}
