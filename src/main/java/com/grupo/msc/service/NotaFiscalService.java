package com.grupo.msc.service;

import java.util.List;

import com.grupo.msc.dto.NotaFiscalDto;
import com.grupo.msc.model.NotaFiscal;

public interface NotaFiscalService {

	public void gerarNota(NotaFiscalDto notaFiscalDto);
	public List<NotaFiscal> listar();
}
