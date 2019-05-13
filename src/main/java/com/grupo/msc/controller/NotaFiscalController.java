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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.msc.dto.NotaFiscalDto;
import com.grupo.msc.model.NotaFiscal;
import com.grupo.msc.response.MessageResponse;
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
	
	@GetMapping("lista")
	public ResponseEntity<NotaFiscal> lista(@RequestParam String numero){
		return new ResponseEntity<NotaFiscal>(nfService.acharPeloNumero(numero), HttpStatus.OK);
	}
	
	@PostMapping("gerarNota")
	public ResponseEntity<MessageResponse> gerarNota(@Valid @RequestBody NotaFiscalDto notaFiscalDto){
		return new ResponseEntity<MessageResponse>(nfService.gerarNota(notaFiscalDto), HttpStatus.CREATED);
	}
 }
