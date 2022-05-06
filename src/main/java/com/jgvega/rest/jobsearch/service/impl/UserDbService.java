package com.jgvega.rest.jobsearch.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;

import com.jgvega.rest.jobsearch.commons.entity.UserDb;
import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Enterprise;
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

	@Override
	public Example<UserDb> createUserDbExampleMatcher(UserDb entity) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase();
		UserDb probe = UserDb.builder().build();
		if (entity.getEmail() != null) {
			probe.setEmail(entity.getEmail());
			matcher = matcher.withMatcher("email", GenericPropertyMatchers.contains());
		}
		if (entity.getName() != null) {
			probe.setName(entity.getName());
			matcher = matcher.withMatcher("name", GenericPropertyMatchers.contains());
		}
		if (entity.getStatus() != null)
			probe.setStatus(entity.getStatus());
		return Example.of(probe, matcher);
	}

	@Override
	public Enterprise parseToEnterprise(UserDb userDb) {
		return Enterprise.builder().createAt(userDb.getCreateAt()).email(userDb.getEmail()).name(userDb.getName())
				.status(userDb.getStatus()).build();
	}
	
	@Override
	public E edit(I id, E newEntity) {
		return findByIdForEdition(id);
	}

	private E findByIdForEdition(I id) {
		return super.findById(id);
	}

}
