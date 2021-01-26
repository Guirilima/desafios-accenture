package br.com.thundercoders.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.thundercoders.model.Lancamento;

public class LancamentoRepository implements RepositoryI<Lancamento> {

	private EntityManager em;

	public LancamentoRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Lancamento save(Lancamento entity) {
		em.getTransaction().begin();
		Lancamento lancamento = em.merge(entity);
		em.getTransaction().commit();
		return lancamento;
	}

	@Override
	public void update(Lancamento entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	@Override
	public List<Lancamento> findAll() {

		return em.createQuery("Select l from Lancamento l", Lancamento.class).getResultList();
	}

	@Override
	public Lancamento findById(Integer id) {
		return em.find(Lancamento.class, id);
	}

}
