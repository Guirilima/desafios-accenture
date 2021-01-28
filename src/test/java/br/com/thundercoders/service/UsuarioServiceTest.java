package br.com.thundercoders.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.utils.ConexaoFactory;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class UsuarioServiceTest {

	private UsuarioService usuarioService;
	private UsuarioRepository usuarioRepository;
	private EntityManager em;

	@BeforeAll
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		usuarioRepository = new UsuarioRepository(em);
		usuarioService = new UsuarioService(usuarioRepository);
	}

	@Test
	@Order(1)
	public void salvaUsuario() throws IllegalAccessException {
		Usuario usuario = this.usuarioService.save(new Usuario("joao.pedro", "12345", "João Pedro", "54798563247"));
		assertNotNull(usuario);
	}

	@Test
	@Order(2)
	public void salvaUsuario2() throws IllegalAccessException {
		Usuario usuario = this.usuarioService.save(new Usuario("igor.shimauti", "56789", "Igor Shimauti", "36285117802"));
		assertNotNull(usuario);
	}
	
	@Test
	@Order(3)
	public void buscarPorId() {
		Usuario usuario = this.usuarioService.findById(1);
		assertNotNull(usuario);
	}

	@Test
	@Order(4)
	public void buscarTodos() {
		List<Usuario> usuarios = this.usuarioService.findAll();
		assertTrue(usuarios.size() > 0);
	}
}
