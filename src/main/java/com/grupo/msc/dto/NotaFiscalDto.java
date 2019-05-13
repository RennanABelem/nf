package com.grupo.msc.dto;

import java.util.List;

public class NotaFiscalDto {

	private String numero;
	private List<Long> itemId;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Long> getItemId() {
		return itemId;
	}

	public void setItemId(List<Long> itemId) {
		this.itemId = itemId;
	}

}
