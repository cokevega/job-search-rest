package com.jgvega.rest.jobsearch.commons.service;

import java.util.List;
import java.util.Optional;

public interface ICommonService<E, I> {

	public List<E> findAll();
	
	public List<E> saveAll(Iterable<E> entities);
	
	public E save(E entity);
	
	public Optional<E> findById(I id);
	
	public void deleteById(I id);
	
}
