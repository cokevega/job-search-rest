package com.jgvega.rest.jobsearch.commons.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public E findById(I id) {
		Optional<E> op = repository.findById(id);
		if (op.isPresent())
			return op.get();
		else
			throw new EntityNotFoundException();
	}

	@Override
	public void deleteById(I id) {
		repository.deleteById(id);
	}

	@Override
	public List<E> filter(E entity) {
		return findAll();
	}

	@Override
	public E edit(I id, E newEntity) {
		return findById(id);
	}

	@Override
	public List<E> findByExample(Example<E> example) {
		return repository.findAll(example);
	}

}
