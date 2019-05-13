package com.grupo.msc.exception.handler;

import org.springframework.http.HttpStatus;

public class ResponseError {

	private String mensagem;
	private Integer codigo;

	public ResponseError(String mensagem, Integer codigo) {
		this.mensagem = mensagem;
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
