package br.com.thundercoders.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.controller.MessageServiceForTest;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.service.UsuarioService;
import br.com.thundercoders.utils.ConexaoFactory;

public class UsuarioTest {

	private UsuarioRepository repository;
	private UsuarioService service;

	@BeforeEach
	public void initialize() {
		this.repository = new UsuarioRepository(ConexaoFactory.getConexao());
		this.service = new UsuarioService(repository);
	}

	@DisplayName("Test MessageService.getCPF()") // E usada para fornecer um nome personalizado para a classe de teste e
													// métodos de teste
	@Test // no JUnit > 4 os métodos de teste são identificados com a anotação @Test
	void loginComprimentoCpfTest() {
		assertEquals(11, MessageServiceForTest.getCPF().getCpf().length());
	}

	@DisplayName("Test MessageService.getApelido()")
	@Test
	void loginComprimentoApelidoTest() {
		assertEquals(true, (MessageServiceForTest.getApelido().getNome().length() < 20));
	}

	// Exemplo em Aula
	@Test
	public void loginComprimentoTest() {
		Usuario usuario = new Usuario();
		usuario.setLogin("Guirilima");
		assertTrue(service.loginComprimento(usuario.getLogin()));
	}

	@Test
	void loginComprimentoInvalidoTest() {
		Usuario usuario = new Usuario();
		usuario.setLogin("Guirilimae3erwrereerere2233234ere");
		assertFalse(service.loginComprimento(usuario.getLogin()));
	}
}
