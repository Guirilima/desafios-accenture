package br.com.thundercoders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.utils.TextoUtils;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {

		this.usuarioRepository = usuarioRepository;
	}

	public boolean loginComprimento(String login) {
		return login.length() <= 20;
	}

	public void incluir(Usuario usuarioEntity) throws IllegalAccessException {

		System.err.println(usuarioEntity.getLogin());
		
		boolean comprimentoValido = TextoUtils.validaComprimento(usuarioEntity.getLogin(), 20);
		if (!comprimentoValido) {
			
			throw new IllegalAccessException("Comprimento inválido");
		}

		Usuario usuarioExists = usuarioRepository.findByLogin(usuarioEntity.getLogin());

		if (usuarioExists != null) // nonNull(usuarioEntity) ){
		{
			throw new IllegalStateException("Já existe um usuario com o login " + usuarioEntity.getLogin());
		}

		usuarioRepository.save(usuarioEntity);
	}

	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário inexistente"));
	}

	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
