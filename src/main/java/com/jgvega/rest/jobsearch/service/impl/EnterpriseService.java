package com.jgvega.rest.jobsearch.service.impl;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.repository.IEnterpriseRepository;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;

@Service
public class EnterpriseService extends UserDbService<Enterprise, Long, IEnterpriseRepository>
		implements IEnterpriseService {

}