package br.com.thundercoders.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.thundercoders.model.dto.DtoPlanoConta;
import br.com.thundercoders.repository.PlanoContaRepository;
import br.com.thundercoders.repository.UsuarioRepository;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class PlanoContaServiceTest {

	private PlanoContaService planoContaService;
	private PlanoContaRepository repository;
	private UsuarioService usuarioService;
	private UsuarioRepository uRepository;

	@BeforeAll
	public void initialize() {
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
