package com.grupo.msc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.msc.dto.NotaFiscalDto;
import com.grupo.msc.exception.ResourceExceptionBadRequest;
import com.grupo.msc.exception.ResourceExceptionNotFound;
import com.grupo.msc.model.ItemDaNota;
import com.grupo.msc.model.NotaFiscal;
import com.grupo.msc.reposito.ItemRepository;
import com.grupo.msc.reposito.NotaFiscalRepository;
import com.grupo.msc.response.MessageResponse;
import com.grupo.msc.service.NotaFiscalService;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService{

	@Autowired 
	private NotaFiscalRepository nfRepo;
	
	@Autowired 
	private ItemRepository itemRepo;
	
	@Override
	public List<NotaFiscal> listar(){
		return nfRepo.findAll();
	}
	
	@Override
	public MessageResponse gerarNota(NotaFiscalDto notaFiscalDto) {
		nfRepo.save(this.parseNF(notaFiscalDto));
		return new MessageResponse("Nota Fiscal gerada com sucesso");
	}
	
	@Override
	public NotaFiscal acharPeloNumero(String numero) {
		Optional<NotaFiscal> nf = nfRepo.findByNumero(numero);
		return nf.orElseThrow(()-> new ResourceExceptionBadRequest("Não existe nota fiscal com o [NUMERO = " + numero + " ] informado"));
	}
	
	private NotaFiscal parseNF(NotaFiscalDto notaFiscalDto) {
		NotaFiscal notaFiscal = new NotaFiscal();
		List<ItemDaNota> itensDaNota = new ArrayList<ItemDaNota>();
		double valorTotal = 0;
		
		for(Long itemId : notaFiscalDto.getItemId()) {
			Optional<ItemDaNota> itemDaNota = itemRepo.findById(itemId);
			ItemDaNota item = itemDaNota.orElseThrow(() -> new ResourceExceptionNotFound("Não existe item com o [ID = " + itemId + "]."));
			
			valorTotal += item.getValor();
			itensDaNota.add(item);
		}
		
		notaFiscal.setValorTotal(valorTotal);
		notaFiscal.setNumero(notaFiscalDto.getNumero());
		notaFiscal.setItens(itensDaNota);
		
		return notaFiscal;
	}
	
}
