package com.grupo.msc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.msc.dto.NotaFiscalDto;
import com.grupo.msc.model.ItemDaNota;
import com.grupo.msc.model.NotaFiscal;
import com.grupo.msc.reposito.ItemRepository;
import com.grupo.msc.reposito.NotaFiscalRepository;
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
	public void gerarNota(NotaFiscalDto notaFiscalDto) {
		nfRepo.save(this.parseNF(notaFiscalDto));
	}
	
	@Override
	public NotaFiscal acharPeloNumero(String numero) {
		return nfRepo.findByNumero(numero);
	}
	
	private NotaFiscal parseNF(NotaFiscalDto notaFiscalDto) {
		NotaFiscal notaFiscal = new NotaFiscal();
		List<ItemDaNota> itensDaNotaFiscal = new ArrayList<ItemDaNota>();
		
		for(Long itemId : notaFiscalDto.getItemId()) {
			Optional<ItemDaNota> itemDaNota = itemRepo.findById(itemId);
			ItemDaNota item = itemDaNota.orElseThrow(() -> new RuntimeException("Não existe item com o [ID = " + itemId + " ]."));
			
			valorTotal += item.getValor();
			itensDaNota.add(item);
		}
		notaFiscal.setNumero(notaFiscalDto.getNumero());
		notaFiscal.setItens(itensDaNota);
		
		return notaFiscal;
	}
	
}
