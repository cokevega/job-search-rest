package com.jgvega.rest.jobsearch.service.impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;

import com.jgvega.rest.jobsearch.commons.entity.UserDb;
import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.repository.IUserDbRepository;
import com.jgvega.rest.jobsearch.service.IUserDbService;

public class UserDbService<E extends UserDb, I, R extends IUserDbRepository<E, I>> extends CommonService<E, I, R>
		implements IUserDbService<E, I> {

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
	public Employee parseToEmployee(UserDb userDb) {
		return Employee.builder().createAt(userDb.getCreateAt()).email(userDb.getEmail()).name(userDb.getName())
				.status(userDb.getStatus()).build();
	}
	
	@Override
	public E edit(I id, E newEntity) {
		E oldEntity=super.edit(id, newEntity);
		oldEntity.setName(newEntity.getName());
		oldEntity.setStatus(newEntity.getStatus());
		return oldEntity;
	}

}
