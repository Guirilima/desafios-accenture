package br.com.thundercoders.repository;

import java.util.List;

public interface RepositoryI<T> {

	public T save(T entity);

	public void update(T entity);

	public List<T> findAll();

	public T findById(Integer id);
}
