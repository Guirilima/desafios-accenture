package br.com.thundercoders.repository;

import javax.persistence.EntityManager;

import br.com.thundercoders.model.Lancamento;

public class LancamentoRepository extends RepositoryImpl<Lancamento, Integer> {

	public LancamentoRepository(EntityManager em) {
		super(em);
	}
}
