package br.com.thundercoders.repository;

import javax.persistence.EntityManager;

import br.com.thundercoders.model.PlanoConta;

public class PlanoContaRepository extends RepositoryImpl<PlanoConta, Integer> {

	public PlanoContaRepository(EntityManager em) {
		super(em);
	}
}
