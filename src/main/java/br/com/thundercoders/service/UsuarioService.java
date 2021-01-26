package br.com.thundercoders.service;

import java.util.Optional;

import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.utils.TextoUtils;

public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public boolean loginComprimento(String login) {
		return login.length() <= 20;
	}

	public void incluir(Usuario usuarioEntity) throws IllegalAccessException {

		boolean comprimentoValido = TextoUtils.validaComprimento(usuarioEntity.getLogin(), 20);
		if (!comprimentoValido) {
			throw new IllegalAccessException();
		}

		usuarioEntity = usuarioRepository.findByLogin(usuarioEntity.getLogin());

		if (usuarioRepository.exists(usuarioEntity.getLogin())) // nonNull(usuarioEntity) ){
		{
			throw new IllegalStateException("Já existe um usuario com o login " + usuarioEntity.getLogin());
		}

		usuarioRepository.incluir(usuarioEntity);
	}

	public Usuario findById(Integer id) {
		Optional<Usuario> usuario = Optional.of(usuarioRepository.findById(id));
		if (!usuario.isPresent()) {
			throw new RuntimeException("Usuário inexistente");
		}

		return usuario.get();
	}
}
