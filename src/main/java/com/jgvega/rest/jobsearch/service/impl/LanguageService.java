package com.jgvega.rest.jobsearch.service.impl;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Language;
import com.jgvega.rest.jobsearch.repository.ILanguageRepository;
import com.jgvega.rest.jobsearch.service.ILanguageService;

@Service
public class LanguageService extends CommonService<Language, Long, ILanguageRepository> implements ILanguageService {

	@Override
	public Language edit(Language oldEntity, Language newEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
