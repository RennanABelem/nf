package com.grupo.msc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.msc.dto.ItemDto;
import com.grupo.msc.model.ItemDaNota;
import com.grupo.msc.response.MessageResponse;
import com.grupo.msc.service.ItemService;

@RestController
@RequestMapping("item")
public class ItemController {

	@Autowired
	private ItemService service;
	
	@PostMapping("salvar")
	public ResponseEntity<MessageResponse> salvar(@Valid @RequestBody ItemDto itemDto){
		return new ResponseEntity<MessageResponse>(service.salvar(itemDto), HttpStatus.CREATED);
	}
	
	@GetMapping("listar")
	public ResponseEntity<List<ItemDaNota>> listar(){
		return new ResponseEntity<List<ItemDaNota>>(service.listar(), HttpStatus.OK);
	}
}
