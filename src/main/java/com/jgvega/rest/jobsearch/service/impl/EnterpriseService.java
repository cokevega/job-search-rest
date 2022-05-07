package com.jgvega.rest.jobsearch.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.entity.UserDb;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.repository.IEnterpriseRepository;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;

@Service
public class EnterpriseService extends UserDbService<Enterprise, Long, IEnterpriseRepository>
		implements IEnterpriseService {

	@Override
	public Enterprise edit(Long id, Enterprise newEntity) {
		Enterprise oldEntity = super.edit(id, newEntity);
		oldEntity.setDescription(newEntity.getDescription());
		oldEntity.setEmail(newEntity.getEmail());
		oldEntity.setName(newEntity.getName());
		oldEntity.setStatus(newEntity.getStatus());
		return save(oldEntity);
	}

	@Override
	public List<Enterprise> filter(Enterprise entity) {
		Example<UserDb> userDbExample = createUserDbExampleMatcher(entity);
		Enterprise probe = parseToEnterprise(userDbExample.getProbe());
		ExampleMatcher matcher = userDbExample.getMatcher();
		if (entity.getDescription() != null) {
			matcher = matcher.withMatcher("description", GenericPropertyMatchers.contains());
			probe.setDescription(entity.getDescription());
		}
		return findByExample(Example.of(probe, matcher));
	}

}