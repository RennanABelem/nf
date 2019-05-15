package com.grupo.msc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.grupo.msc.exception.ResourceExceptionBadRequest;
import com.grupo.msc.response.ContaResponse;
import com.grupo.msc.service.ConsultaContaService;

@Service
public class ConsultarContaServiceImpl implements ConsultaContaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarContaServiceImpl.class);
	
	@Value("${url-conta}")
	private String urlConta;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public ContaResponse consultarConta(Long numeroConta) {
		try{
			ContaResponse contaResponse = restTemplate.getForObject(urlConta, ContaResponse.class, numeroConta);
				LOGGER.info("Conta Encontrada com sucesso: " + contaResponse.toString());
				return contaResponse;
		}catch(HttpClientErrorException ex) {
			LOGGER.info("Conta não encontrada. Número da conta = " + numeroConta);
			throw new ResourceExceptionBadRequest("Conta não encontrada");
		}
	}
	
}
