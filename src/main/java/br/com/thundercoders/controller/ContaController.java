package br.com.thundercoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thundercoders.model.ContaCredito;
import br.com.thundercoders.service.ContaService;

@RestController
@RequestMapping("conta")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	
	@PostMapping
	public void novaContaCredito(@RequestBody ContaCredito contaCredito) {
		contaService.save(contaCredito);
	}
	
}
