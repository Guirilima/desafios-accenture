package br.com.thundercoders.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.thundercoders.model.PlanoConta;

public class PlanoContaRepository implements Repository<PlanoConta> {

	private final EntityManager em;

	public PlanoContaRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public PlanoConta save(PlanoConta planoConta) {
		em.getTransaction().begin();
		planoConta = em.merge(planoConta);
		em.getTransaction().commit();
		return planoConta;
	}

	@Override
	public List<PlanoConta> findAll() {
		return this.em.createQuery("SELECT p from PlanoConta p", PlanoConta.class).getResultList();
	}

	@Override
	public PlanoConta findById(Integer id) {
		return this.em.find(PlanoConta.class, id);
	}

	@Override
	public void update(PlanoConta planoConta) {
		this.update(planoConta);
	}

}
