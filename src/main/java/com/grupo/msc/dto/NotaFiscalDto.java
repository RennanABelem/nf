package com.grupo.msc.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NotaFiscalDto {
	
	@NotNull(message="O campo [numero] não pode ser nulo")
	private Long numero;
	
	@NotEmpty(message="O campo [itemId] não pode ser nulo")
	private List<Long> itemId;
	
	@NotEmpty(message="O campo [numeroConta] não pode ser nulo")
	@Size(min = 4, max = 4, message = "O campo[numero] deve ter 4 digitos.")
	private String numeroConta;
	
	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public List<Long> getItemId() {
		return itemId;
	}

	public void setItemId(List<Long> itemId) {
		this.itemId = itemId;
	}

}
