package br.com.thundercoders.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.repository.UsuarioRepository;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class UsuarioServiceTest {

	@InjectMocks
	private UsuarioService usuarioService;
	@MockBean
	private UsuarioRepository usuarioRepository;
	private Usuario usuario;

//	@BeforeAll
//	public void initialize() {
//		usuario = this.usuarioService.save(new Usuario("joao.pedro", "12345", "João Pedro", "54798563247"));
//	}
//
//	@Test
//	@Order(1)
//	public void salvaUsuario() throws IllegalAccessException {
//		Usuario usuario = new Usuario("joao.pedro", "12345", "João Pedro", "54798563247");
//		when(usuarioRepository.save(usuario)).thenReturn(new Usuario());
//		Usuario save = usuarioService.save(usuario);
//		assertNotNull(save);
//	}
	/*
	 * @Test
	 * 
	 * @Order(2) public void salvaUsuario2() throws IllegalAccessException { Usuario
	 * usuario = this.usuarioService .save(new Usuario("igor.shimauti", "56789",
	 * "Igor Shimauti", "36285117802")); assertNotNull(usuario); }
	 * 
	 * @Test
	 * 
	 * @Order(3) public void buscarPorId() { Usuario usuario =
	 * this.usuarioService.findById(1); assertNotNull(usuario); }
	 * 
	 * @Test
	 * 
	 * @Order(4) public void buscarTodos() { List<Usuario> usuarios =
	 * this.usuarioService.findAll(); assertTrue(usuarios.size() > 0); }
	 */
}
