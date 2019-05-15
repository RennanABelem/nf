package com.grupo.msc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.msc.dto.NotaFiscalDto;
import com.grupo.msc.exception.ResourceExceptionBadRequest;
import com.grupo.msc.exception.ResourceExceptionNotFound;
import com.grupo.msc.model.ItemDaNota;
import com.grupo.msc.model.NotaFiscal;
import com.grupo.msc.reposito.ItemRepository;
import com.grupo.msc.reposito.NotaFiscalRepository;
import com.grupo.msc.response.ContaResponse;
import com.grupo.msc.response.MessageResponse;
import com.grupo.msc.response.NotaFiscalResponse;
import com.grupo.msc.service.ConsultaContaService;
import com.grupo.msc.service.NotaFiscalService;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {

	private static final Logger logger = LoggerFactory.getLogger(NotaFiscalServiceImpl.class);
	
	@Autowired
	private NotaFiscalRepository nfRepo;

	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private ConsultaContaService contaService;

	@Override
	public List<NotaFiscal> listar() {
		return nfRepo.findAll();
	}

	@Override
	public NotaFiscal acharPeloNumero(Long numero) {
		Optional<NotaFiscal> nf = nfRepo.findByNumero(numero);
		return nf.orElseThrow(() -> new ResourceExceptionBadRequest(
				"Não existe nota fiscal com o [NUMERO = " + numero + " ] informado"));
	}
	
	@Override
	public MessageResponse gerarNota(NotaFiscalDto notaFiscalDto) {
		return new MessageResponse("Nota fiscal gerada com sucesso!",  new NotaFiscalResponse(nfRepo.save(this.parseNotaFiscal(notaFiscalDto))));
	}

	private NotaFiscal parseNotaFiscal(NotaFiscalDto notaFiscalDto) {
		NotaFiscal notaFiscal = new NotaFiscal();
		List<ItemDaNota> itensDaNota = new ArrayList<ItemDaNota>();
		double valorTotal = 0;

		for (Long itemId : notaFiscalDto.getItemId()) {
			Optional<ItemDaNota> itemDaNota = itemRepo.findById(itemId);
			ItemDaNota item = itemDaNota.orElseThrow(() -> new ResourceExceptionNotFound("Não existe item com o [ID = " + itemId + "]."));

			valorTotal += item.getValor();
			itensDaNota.add(item);
		}

		notaFiscal.setValorTotal(valorTotal);
		notaFiscal.setNumero(notaFiscalDto.getNumero());
		notaFiscal.setItens(itensDaNota);
		ContaResponse contaResponse = contaService.consultarConta(Long.valueOf(notaFiscalDto.getNumeroConta()));
		
		return this.calculaSaldo(contaResponse, notaFiscal);
	}
	
	private NotaFiscal calculaSaldo(ContaResponse contaResponse, NotaFiscal notaFiscal) {
		if(contaResponse.getSaldo() > notaFiscal.getValorTotal()) {
			contaResponse.setSaldo(contaResponse.getSaldo() - notaFiscal.getValorTotal());
			notaFiscal.setNomeTitular(contaResponse.getNomeTitular());
			return notaFiscal;
		} else {
			throw new ResourceExceptionBadRequest("Não foi possível gerar a [nota fiscal]. Motivo = SALDO insuficiente!");
		}
	}
	
}
