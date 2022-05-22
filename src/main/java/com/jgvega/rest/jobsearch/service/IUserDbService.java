package com.jgvega.rest.jobsearch.service;

import org.springframework.data.domain.Example;

import com.jgvega.rest.jobsearch.commons.entity.UserDb;
import com.jgvega.rest.jobsearch.commons.service.ICommonService;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.entity.Enterprise;

public interface IUserDbService<E extends UserDb, I> extends ICommonService<E, I> {
	
	Example<UserDb> createUserDbExampleMatcher(UserDb entity);
	
	Enterprise parseToEnterprise(UserDb userDb);
	
	Employee parseToEmployee(UserDb userDb);
}
