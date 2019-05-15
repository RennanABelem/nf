package com.grupo.msc.response;

public class MessageResponse {

	private String message;
	private NotaFiscalResponse notaFiscalResponse;

	public MessageResponse(String message, NotaFiscalResponse notaFiscalResponse) {
		this.message = message;
		this.notaFiscalResponse = notaFiscalResponse;
	}
	
	public MessageResponse(String message) {
		this.message = message;
	}

	public NotaFiscalResponse getNotaFiscalResponse() {
		return notaFiscalResponse;
	}

	public void setNotaFiscalResponse(NotaFiscalResponse notaFiscalResponse) {
		this.notaFiscalResponse = notaFiscalResponse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
