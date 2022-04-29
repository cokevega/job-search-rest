package com.jgvega.rest.jobsearch.commons.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jgvega.rest.jobsearch.commons.service.ICommonService;

public class CommonService<E, I, R extends JpaRepository<E, I>> implements ICommonService<E, I> {

	@Autowired
	protected R repository;

	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public List<E> saveAll(Iterable<E> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public E save(E entity) {
		return repository.save(entity);
	}

	@Override
	public Optional<E> findById(I id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(I id) {
		repository.deleteById(id);
	}

}
