package br.com.thundercoders.repository;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.utils.ConexaoFactory;

class PlanoContaRepositoryTest {

	private PlanoContaRepository repository;
	private UsuarioRepository usuarioRepository;
	private EntityManager em;

	@Before
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		this.repository = new PlanoContaRepository(em);
		this.usuarioRepository = new UsuarioRepository(em);
	}

	@Test
	void salvarPlanoContasTest() {
		Usuario usuario = usuarioRepository
				.save(new Usuario("franklin-barreto@hotmail.com", "123456", "Franklin Barreto", "32545478956"));

		usuarioRepository.save(usuario);
		PlanoConta planoConta = new PlanoConta(usuario, LancamentoTipo.CREDITO, "Pagamento de salário");
		PlanoConta save = repository.save(planoConta);
		assertNotNull(save.getId());
	}

}
