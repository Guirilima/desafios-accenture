package br.com.thundercoders.repository;

import java.util.List;

public interface Repository<T> {

	public T save(T entity);

	public List<T> findAll();

	public T findById(Integer id);

	public void update(Integer id, T entity);
}
