package com.grupo.msc.service;

import java.util.List;

import com.grupo.msc.dto.ItemDto;
import com.grupo.msc.model.ItemDaNota;
import com.grupo.msc.response.MessageResponse;

public interface ItemService {

	public MessageResponse salvar(ItemDto itemDto);
	public List<ItemDaNota> listar();
}
