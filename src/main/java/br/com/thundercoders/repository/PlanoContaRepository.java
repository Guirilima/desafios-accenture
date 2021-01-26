package br.com.thundercoders.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.thundercoders.model.PlanoConta;

public class PlanoContaRepository implements RepositoryI<PlanoConta> {

	private EntityManager em;

	public PlanoContaRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public PlanoConta save(PlanoConta entity) {
		em.getTransaction().begin();
		PlanoConta planoConta = em.merge(entity);
		em.getTransaction().commit();
		return planoConta;
	}

	@Override
	public void update(PlanoConta entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	@Override
	public List<PlanoConta> findAll() {

		return em.createQuery("Select p from Plano p", PlanoConta.class).getResultList();
	}

	@Override
	public PlanoConta findById(Integer id) {
		return em.find(PlanoConta.class, id);
	}

}
