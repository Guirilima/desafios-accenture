package br.com.thundercoders.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.thundercoders.model.Usuario;

public class UsuarioRepository extends RepositoryImpl<Usuario, Integer> {

	public UsuarioRepository(EntityManager em) {
		super(em);
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
}
