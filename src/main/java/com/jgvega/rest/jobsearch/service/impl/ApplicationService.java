package com.jgvega.rest.jobsearch.service.impl;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Application;
import com.jgvega.rest.jobsearch.repository.IApplicationRepository;
import com.jgvega.rest.jobsearch.service.IApplicationService;

@Service
public class ApplicationService extends CommonService<Application, Long, IApplicationRepository>
		implements IApplicationService {

	@Override
	public Application edit(Application oldEntity, Application newEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
