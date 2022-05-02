package com.jgvega.rest.jobsearch.commons.service;

import java.util.List;

public interface ICommonService<E, I> {

	public List<E> findAll();

	public List<E> saveAll(Iterable<E> entities);

	public E save(E entity);

	public E findById(I id);
	
	public E edit(E oldEntity, E newEntity);

	public void deleteById(I id);

}
