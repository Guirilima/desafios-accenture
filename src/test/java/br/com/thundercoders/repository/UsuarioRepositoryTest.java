package br.com.thundercoders.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.utils.ConexaoFactory;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class UsuarioRepositoryTest {

	private UsuarioRepository repository;
	private EntityManager em;

	@BeforeAll
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		repository = new UsuarioRepository(em);
	}

	@Order(1)
	@Test
	void salvarUsuario() {
		Usuario usuario = (Usuario) repository.save(new Usuario("franklin-barreto", "12345", "Franklin Barreto", "12345678910"));
		assertNotNull(usuario.getId());//(3, usuario.getId());
	}
	
	@Order(2)
	@Test
	void buscarUsuarioPorIdentificador() {
		Usuario usuario = (Usuario) repository.findById(1);
		assertEquals("franklin-barreto", usuario.getLogin());
	}

}
