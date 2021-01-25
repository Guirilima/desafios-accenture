package br.com.thundercoders.service;

import java.util.List;

public interface Service<T> {

	public T save(T entity);

	public List<T> findAll();

	public T findById(Integer id);

	public void update(Integer id,T entity);

}
