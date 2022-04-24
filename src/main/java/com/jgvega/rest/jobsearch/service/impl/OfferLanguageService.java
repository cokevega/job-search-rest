package com.jgvega.rest.jobsearch.service.impl;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.CommonService;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.entity.key.OfferLanguageKey;
import com.jgvega.rest.jobsearch.repository.IOfferLanguageRepository;
import com.jgvega.rest.jobsearch.service.IOfferLanguageService;

@Service
public class OfferLanguageService extends CommonService<OfferLanguage, OfferLanguageKey, IOfferLanguageRepository>
		implements IOfferLanguageService {

}
