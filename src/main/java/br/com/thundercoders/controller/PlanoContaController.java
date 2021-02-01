package br.com.thundercoders.controller;

import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.dto.DtoPlanoConta;
import br.com.thundercoders.service.PlanoContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/plano-conta")
@Api(value = "plano-conta-controller", tags ="Plano de Conta")
public class PlanoContaController {

    private PlanoContaService planoContaService;

    public PlanoContaController(PlanoContaService planoContaService) {
        this.planoContaService = planoContaService;
    }

    @PostMapping
    @ApiOperation(value = "salva um plano de conta no banco de dados")
    public ResponseEntity<DtoPlanoConta> salvar(@ApiParam(value = "DtoPlanoConta", required = true)  @RequestBody DtoPlanoConta dtoPlanoConta, UriComponentsBuilder uriBuilder) {

        PlanoConta planoConta = planoContaService.salvaPlanoConta(dtoPlanoConta);
        dtoPlanoConta = dtoPlanoConta.converter(planoConta);
        URI uri = uriBuilder.path("plano-conta/{id}").buildAndExpand(planoConta.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoPlanoConta);
    }

}
