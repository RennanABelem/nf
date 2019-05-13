package com.grupo.msc.exception.handler;

import java.util.ArrayList;
import java.util.List;

public class ResponseError {

	private String mensagem;
	private Integer codigo;
	private List<String> errors;

	public ResponseError(String mensagem, Integer codigo) {
		this.mensagem = mensagem;
		this.codigo = codigo;
		errors = new ArrayList<String>();
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

}
