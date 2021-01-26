package br.com.thundercoders.service;

import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoPlanoConta;
import br.com.thundercoders.repository.PlanoContaRepository;

public class PlanoContaService {

	private UsuarioService usuarioService;
	private PlanoContaRepository planoContaRepository;

	public PlanoContaService(UsuarioService usuarioService, PlanoContaRepository planoContaRepository) {
		this.usuarioService = usuarioService;
		this.planoContaRepository = planoContaRepository;
	}

	public PlanoConta salvaPlanoConta(DtoPlanoConta dtoPlanoConta) {
		Usuario usuario = usuarioService.findById(dtoPlanoConta.getUsuarioId());
		return planoContaRepository.save(new PlanoConta(usuario, dtoPlanoConta.getDescricao()));
	}

}
