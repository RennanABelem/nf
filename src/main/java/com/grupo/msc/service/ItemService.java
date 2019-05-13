package com.grupo.msc.service;

import java.util.List;

import com.grupo.msc.dto.ItemDto;
import com.grupo.msc.model.ItemDaNota;

public interface ItemService {

	public void salvar(ItemDto itemDto);
	public List<ItemDaNota> listar();
}
