package com.grupo.msc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.msc.dto.NotaFiscalDto;
import com.grupo.msc.model.NotaFiscal;
import com.grupo.msc.service.NotaFiscalService;

@RestController
@RequestMapping("notaFiscal")
public class NotaFiscalController {

	@Autowired
	private NotaFiscalService nfService;
	
	@GetMapping("listar")
	public ResponseEntity<List<NotaFiscal>> listar(){
		return new ResponseEntity<List<NotaFiscal>>(nfService.listar(), HttpStatus.OK);
	}
	
	@PostMapping("gerarNota")
	public ResponseEntity<Void> gerarNota(@RequestBody NotaFiscalDto notaFiscalDto){
		nfService.gerarNota(notaFiscalDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
 }
