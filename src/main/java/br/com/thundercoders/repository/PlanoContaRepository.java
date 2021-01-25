package br.com.thundercoders.repository;

import java.beans.Beans;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtils;

import br.com.thundercoders.model.PlanoConta;

public class PlanoContaRepository implements Repository<PlanoConta> {

	private final EntityManager em;

	public PlanoContaRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public PlanoConta save(PlanoConta planoConta) {

		return this.em.merge(planoConta);
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
	public void update(Integer id, PlanoConta planoConta) {
		PlanoConta planoContaDb = findById(id);
		try {
			BeanUtils.copyProperties(planoConta, planoContaDb);
			this.em.merge(planoContaDb);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
