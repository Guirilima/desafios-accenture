package br.com.thundercoders.service;

import java.util.List;

import br.com.thundercoders.model.EntidadeBase;
import br.com.thundercoders.repository.RepositoryI;

public class ServiceImpl<T extends EntidadeBase> implements ServiceI<T> {

	protected RepositoryI<T, Integer> repository;

	public ServiceImpl(RepositoryI<T, Integer> repository) {
		this.repository = repository;
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> findAll() {

		return repository.findAll();
	}

	@Override
	public T findById(Integer id) {
		return repository.findById(id);
	}

}
