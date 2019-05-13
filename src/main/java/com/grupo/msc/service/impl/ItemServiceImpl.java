package com.grupo.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.msc.dto.ItemDto;
import com.grupo.msc.model.ItemDaNota;
import com.grupo.msc.reposito.ItemRepository;
import com.grupo.msc.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository repo;
	
	@Override
	public void salvar(ItemDto itemDto) {
		ItemDaNota itemDaNota = new ItemDaNota(itemDto);
		
		repo.save(itemDaNota);
	}
	
	@Override
	public List<ItemDaNota> listar(){
		return repo.findAll();
	}
}
