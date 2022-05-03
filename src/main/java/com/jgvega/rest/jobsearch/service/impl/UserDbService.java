package com.jgvega.rest.jobsearch.service.impl;

import java.util.List;

import com.jgvega.rest.jobsearch.commons.entity.UserDb;
import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.repository.IUserDbRepository;
import com.jgvega.rest.jobsearch.service.IUserDbService;

public class UserDbService<E extends UserDb, I, R extends IUserDbRepository<E, I>> extends CommonService<E, I, R>
		implements IUserDbService<E, I> {

	@Override
	public List<E> findAll() {
		List<E> entities = super.findAll();
		entities.stream().forEach(e -> e.setPassword(null));
		return entities;
	}

	@Override
	public E findById(I id) {
		E entity = super.findById(id);
		entity.setPassword(null);
		return entity;
	}

	@Override
	public E save(E entity) {
		E savedEntity = super.save(entity);
		savedEntity.setPassword(null);
		return savedEntity;
	}

}
