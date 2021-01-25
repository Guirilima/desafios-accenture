package br.com.thundercoders.service;

import java.util.List;

import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.repository.Repository;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.utils.TextoUtils;

public class UsuarioService implements Service<Usuario> {

	private UsuarioRepository rep;

	public UsuarioService(Repository<Usuario> rep) {
		this.rep = (UsuarioRepository) rep;
	}

	public boolean loginComprimento(String login) {
		return login.length() <= 20;
	}

	@Override
	public Usuario save(Usuario entity) {

		boolean comprimentoValido = TextoUtils.validaComprimento(entity.getLogin(), 20);
		if (!comprimentoValido) {
			throw new RuntimeException("Tamanho inválido");
		}

		if (rep.exists(entity.getLogin())) // nonNull(usuarioEntity) ){
		{
			throw new IllegalStateException("Já existe um usuario com o login " + entity.getLogin());
		}

		return rep.save(entity);
	}

	@Override
	public List<Usuario> findAll() {

		return rep.findAll();
	}

	@Override
	public Usuario findById(Integer id) {
		return rep.findById(id);
	}

	@Override
	public void update(Integer id, Usuario entity) {
		// TODO Auto-generated method stub

	}

}
