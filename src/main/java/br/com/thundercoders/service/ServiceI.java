package br.com.thundercoders.service;

import java.util.List;

public interface ServiceI<T> {

	public T save(T entity);

	public void update(T entity);

	public List<T> findAll();

	public T findById(Integer id);

}
