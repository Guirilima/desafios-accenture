package br.com.thundercoders.repository;

import javax.persistence.EntityManager;

import br.com.thundercoders.model.Conta;

public class ContaRepository extends RepositoryImpl<Conta, Integer>{


	public ContaRepository(EntityManager em) {
		super(em);
	}

}
