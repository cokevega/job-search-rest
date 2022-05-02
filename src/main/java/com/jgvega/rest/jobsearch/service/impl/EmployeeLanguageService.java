package com.jgvega.rest.jobsearch.service.impl;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.entity.key.EmployeeLanguageKey;
import com.jgvega.rest.jobsearch.repository.IEmployeeLanguageRepository;
import com.jgvega.rest.jobsearch.service.IEmployeeLanguageService;

@Service
public class EmployeeLanguageService
		extends CommonService<EmployeeLanguage, EmployeeLanguageKey, IEmployeeLanguageRepository>
		implements IEmployeeLanguageService {

}
