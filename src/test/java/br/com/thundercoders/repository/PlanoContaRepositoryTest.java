package br.com.thundercoders.repository;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.utils.ConexaoFactory;

class PlanoContaRepositoryTest {

	private PlanoContaRepository repository;
	private UsuarioRepository usuarioRepository;
	private EntityManager em;

	@BeforeEach
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		this.repository = new PlanoContaRepository(em);
		this.usuarioRepository = new UsuarioRepository(em);
	}

	@Test
	void salvarPlanoContasTest() {
		Usuario usuario = usuarioRepository
				.save(new Usuario("franklin-barreto", "12345", "Franklin Barreto", "12345678910"));
		PlanoConta planoConta = new PlanoConta(usuario, "Pagamento de salário");
		PlanoConta save = repository.save(planoConta);
		assertNotNull(save.getId());
	}

}
