package com.jgvega.rest.jobsearch.service.impl;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.repository.IEnterpriseRepository;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;

@Service
public class EnterpriseService extends CommonService<Enterprise, Long, IEnterpriseRepository>
		implements IEnterpriseService {

	@Override
	public Enterprise edit(Enterprise oldEntity, Enterprise newEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
