package com.jgvega.rest.jobsearch.commons.service;

import java.util.List;

import org.springframework.data.domain.Example;

public interface ICommonService<E, I> {

	public List<E> findAll();

	public List<E> saveAll(Iterable<E> entities);

	public E save(E entity);

	public E findById(I id);
	
	public E edit(I id, E newEntity);

	public void deleteById(I id);
	
	public List<E> filter(E entity);
	
	public List<E> findByExample(Example<E> example);

}
