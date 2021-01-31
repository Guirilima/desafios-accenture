package br.com.thundercoders.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.dto.DtoPlanoConta;
import br.com.thundercoders.service.PlanoContaService;

@RestController
@RequestMapping("/plano-conta")
public class PlanoContaController {

	private PlanoContaService planoContaService;

	public PlanoContaController(PlanoContaService planoContaService) {
		this.planoContaService = planoContaService;
	}

	@PostMapping
	public ResponseEntity<DtoPlanoConta> salvar(@RequestBody DtoPlanoConta dtoPlanoConta,
			UriComponentsBuilder uriBuilder) {

		PlanoConta planoConta = planoContaService.salvaPlanoConta(dtoPlanoConta);
		dtoPlanoConta = dtoPlanoConta.converter(planoConta);
		URI uri = uriBuilder.path("plano-conta/{id}").buildAndExpand(planoConta.getId()).toUri();
		return ResponseEntity.created(uri).body(dtoPlanoConta);
	}

}
