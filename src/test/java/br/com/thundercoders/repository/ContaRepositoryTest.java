package br.com.thundercoders.repository;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.ContaTipo;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.service.UsuarioService;
import br.com.thundercoders.utils.ConexaoFactory;

@TestInstance(Lifecycle.PER_CLASS)
public class ContaRepositoryTest {

	private ContaRepository contaRepository;
	private UsuarioService usuarioService;
	private UsuarioRepository usuarioRepository;
	private EntityManager em;

	@BeforeAll
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		this.usuarioRepository = new UsuarioRepository(em);
		this.usuarioService = new UsuarioService(usuarioRepository);
		contaRepository = new ContaRepository(em);
	}

	@Test
	public void salvaConta() {
		Usuario usuario = usuarioService.save(new Usuario("joao.joaquim","123456", "joao", "1234567890"));
		Conta conta = contaRepository.save(new ContaCorrente(usuario, ContaTipo.CORRENTE.toString(), "124-9", 200.0));
		assertNotNull(conta);
	}
}
