package br.com.thundercoders.service;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.model.dto.DtoPlanoConta;
import br.com.thundercoders.repository.PlanoContaRepository;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.utils.ConexaoFactory;

public class PlanoContaServiceTest {

	private PlanoContaService planoContaService;
	private PlanoContaRepository repository;
	private UsuarioService usuarioService;
	private UsuarioRepository uRepository;
	private EntityManager em;
	

	@BeforeEach
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		this.repository = new PlanoContaRepository(em);
		this.uRepository = new UsuarioRepository(em);
		this.usuarioService = new UsuarioService(uRepository);
		this.planoContaService = new PlanoContaService(usuarioService, repository);
	}

	@Test
	@Order(1)
	public void salvaPlanoContaServiceTest() {
		planoContaService.salvaPlanoConta(new DtoPlanoConta(1, "Alimentação"));
	}
	
	@Test
	@Order(2)
	public void salvaPlanoContaServiceTest2() {
		planoContaService.salvaPlanoConta(new DtoPlanoConta(1, "Combutível"));
	}
	
	@Test
	@Order(3)
	public void salvaPlanoContaServiceTest3() {
		planoContaService.salvaPlanoConta(new DtoPlanoConta(2, "Alimentação"));
	}
	
	@Test
	@Order(4)
	public void salvaPlanoContaServiceTest4() {
		planoContaService.salvaPlanoConta(new DtoPlanoConta(2, "Combutível"));
	}
}
