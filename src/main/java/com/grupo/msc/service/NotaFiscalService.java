package com.grupo.msc.service;

import java.util.List;

import com.grupo.msc.dto.NotaFiscalDto;
import com.grupo.msc.model.NotaFiscal;
import com.grupo.msc.response.MessageResponse;

public interface NotaFiscalService {

	public MessageResponse gerarNota(NotaFiscalDto notaFiscalDto);
	public List<NotaFiscal> listar();
	public NotaFiscal acharPeloNumero(Long numero);
}
