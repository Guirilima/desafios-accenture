package br.com.thundercoders.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thundercoders.model.ContaCredito;
import br.com.thundercoders.service.ContaService;

@RestController
@RequestMapping("conta")
@Api(value= "conta-controller", tags = "Conta Bancária (Corrente ou Crédito)")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@ApiOperation(value = "cria uma nova conta do tipo crédito")
	@PostMapping
	public void novaContaCredito(@ApiParam(value = "Conta tipo Crédito", required = true)  @RequestBody ContaCredito contaCredito) {
		contaService.save(contaCredito);
	}
	
}
