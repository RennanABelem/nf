package com.grupo.msc.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NotaFiscalDto {
	
	@NotNull(message="O campo [numero] não pode ser nulo")
	private Long numero;
	
	@NotEmpty(message="O campo [itemId] não pode ser nulo")
	private List<Long> itemId;

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
