package br.com.thundercoders.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.thundercoders.model.Usuario;

public class UsuarioRepository implements RepositoryI<Usuario> {
	private EntityManager em;

	public UsuarioRepository(EntityManager em) {
		this.em = em;
	}

	public UsuarioRepository() {

	}

	public boolean exists(String login) {
		Query query = em.createQuery("SELECT tu FROM Usuario tu WHERE tu.login = :login"); // JPQL
		query.setParameter("login", login);
		return query.getResultList().size() != 0;
	}

	public Usuario findByLogin(String login) {
		Query query = em.createQuery("SELECT tu FROM Usuario tu WHERE tu.login = :login"); // JPQL
		query.setParameter("login", login);

		Usuario usuariousuario = null;
		try {
			usuariousuario = (Usuario) query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException nre) {
			// usuariousuario = null; // Irrelevante, pois ele já é null . . .
		}
		return usuariousuario;
	}

	public void incluir(Usuario usuario) {

	}

	public void alterar(Usuario usuario) {
	}

	@Override
	public Usuario save(Usuario usuario) {

		em.getTransaction().begin();
		Usuario user = em.merge(usuario);
		em.getTransaction().commit();
		return user;
	}

	@Override
	public void update(Usuario usuario) {

		em.getTransaction().begin();
		em.merge(usuario); // Irá alterar um único objeto
		em.getTransaction().commit();

	}

	@Override
	public List<Usuario> findAll() {
		
		return em.createQuery("Select u from Usuario u",Usuario.class).getResultList();
	}

	@Override
	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}
}
