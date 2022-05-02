package com.jgvega.rest.jobsearch.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.repository.IEnterpriseRepository;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;

@Service
public class EnterpriseService extends CommonService<Enterprise, Long, IEnterpriseRepository>
		implements IEnterpriseService {

	@Override
	public List<Enterprise> findAll() {
		List<Enterprise> enterprises = super.findAll();
		enterprises.stream().forEach(e -> e.setPassword(null));
		return enterprises;
	}

	@Override
	public Enterprise findById(Long id) {
		Enterprise enterprise = super.findById(id);
		enterprise.setPassword(null);
		return enterprise;
	}
	
	@Override
	public Enterprise save(Enterprise entity) {
		Enterprise enterprise=super.save(entity);
		enterprise.setPassword(null);
		return enterprise;
	}

}