package br.com.thundercoders.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.thundercoders.model.Conta;

public class ContaRepository implements RepositoryI<Conta> {

	private EntityManager em;

	public ContaRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Conta save(Conta entity) {
		em.getTransaction().begin();
		Conta conta = em.merge(entity);
		em.getTransaction().commit();
		return conta;
	}

	@Override
	public void update(Conta entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Conta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conta findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Conta.class, id);
	}

}
