package br.com.thundercoders.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.utils.ConexaoFactory;

class UsuarioRepositoryTest {

	private UsuarioRepository repository;

	@BeforeEach
	public void initialize() {
		repository = new UsuarioRepository(ConexaoFactory.getConexao());
	}

	@Test
	void salvarUsuario() {
		Usuario usuario = repository.save(new Usuario("franklin-barreto", "12345", "Franklin Barreto", "12345678910"));
		assertNotNull(usuario.getId());//(3, usuario.getId());
	}

}
