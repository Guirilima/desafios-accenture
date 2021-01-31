package br.com.thundercoders.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.Usuario;

@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
class PlanoContaRepositoryTest {

	@Autowired
	private PlanoContaRepository repository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	private Usuario usuario;

	@BeforeAll
	public void initialize() {
	   usuarioRepository.save(new Usuario("franklin-barreto", "12345", "Franklin Barreto", "12345678910"));
	   usuarioRepository.save(new Usuario("franklin-barreto41", "12345", "Franklin Barreto", "12345678910"));
	}

	@Test
	@Order(1)
	void salvarPlanoContasTest() {
		usuario = usuarioRepository.findById(1).orElseThrow(() -> new RuntimeException("usuário inexistente"));
		PlanoConta planoConta = new PlanoConta(usuario, "Pagamento de salário");
		PlanoConta save = repository.save(planoConta);
		assertNotNull(save.getId());
	}

	@Test
	@Order(2)
	void salvarPlanoContasTest2() {
		Usuario usuario = usuarioRepository.findById(2).orElseThrow(() -> new RuntimeException("usuário inexistente"));
		PlanoConta planoConta = new PlanoConta(usuario, "Pagamento de salário");
		PlanoConta save = repository.save(planoConta);
		assertNotNull(save.getId());
	}
}
