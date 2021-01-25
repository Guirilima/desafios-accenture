package br.com.thundercoders.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.thundercoders.model.Usuario;

public class UsuarioRepository implements Repository<Usuario> {
	private EntityManager em;

	public UsuarioRepository(EntityManager em) {
		System.out.println("Construtor");
		this.em = em;
	}

	@Override
	public Usuario save(Usuario entity) {
		em.getTransaction().begin();
		Usuario usuarioSaved = em.merge(entity);
		em.getTransaction().commit();
		return usuarioSaved;
	}

	@Override
	public List<Usuario> findAll() {
		return this.em.createQuery("Select u From Usuario u", Usuario.class).getResultList();
	}

	@Override
	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public void update(Usuario entity) {
		em.getTransaction().begin();
		em.merge(entity); // Irá alterar um único objeto
		em.getTransaction().commit();
		// TODO Auto-generated method stub

	}

	public boolean exists(String login) {
		Query query = em.createQuery("SELECT tu FROM UsuarioEntity tu WHERE tu.login = :login"); // JPQL
		query.setParameter("login", login);
		return query.getResultList().size() != 0;
	}

	public Usuario findByLogin(String login) {
		Query query = em.createQuery("SELECT tu FROM UsuarioEntity tu WHERE tu.login = :login"); // JPQL
		query.setParameter("login", login);

		Usuario usuarioEntity = null;
		try {
			usuarioEntity = (Usuario) query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException nre) {
			// usuarioEntity = null; // Irrelevante, pois ele já é null . . .
		}
		return usuarioEntity;
	}

}
