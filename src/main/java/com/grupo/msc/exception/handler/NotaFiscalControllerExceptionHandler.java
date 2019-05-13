package com.grupo.msc.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.grupo.msc.exception.ResourceExceptionBadRequest;
import com.grupo.msc.exception.ResourceExceptionNotFound;

@ControllerAdvice
public class NotaFiscalControllerExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> defaultHandler(Exception ex, WebRequest request) {
        ResponseError response = new ResponseError("Algo deu errado - Serviço indisponível", HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.info(ex.getMessage());
        ex.printStackTrace();
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
	
	@ExceptionHandler(ResourceExceptionNotFound.class)
	public ResponseEntity<Object> resourceExceptionNotFound(ResourceExceptionNotFound ex, WebRequest request){
		ResponseError response = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		logger.info(ex.getMessage());
		ex.printStackTrace();
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(ResourceExceptionBadRequest.class)
	public ResponseEntity<Object> resourceBadRequest(ResourceExceptionBadRequest ex, WebRequest request){
		ResponseError response = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		logger.info(ex.getMessage());
		ex.printStackTrace();
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	

}
