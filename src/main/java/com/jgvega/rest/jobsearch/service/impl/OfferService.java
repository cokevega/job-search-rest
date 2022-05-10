package com.jgvega.rest.jobsearch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.entity.key.OfferLanguageKey;
import com.jgvega.rest.jobsearch.repository.IOfferRepository;
import com.jgvega.rest.jobsearch.service.ICategoryService;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;
import com.jgvega.rest.jobsearch.service.ILanguageService;
import com.jgvega.rest.jobsearch.service.IOfferLanguageService;
import com.jgvega.rest.jobsearch.service.IOfferService;

@Service
public class OfferService extends CommonService<Offer, Long, IOfferRepository> implements IOfferService {

	@Autowired
	private IEnterpriseService enterpriseService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ILanguageService languageService;
	@Autowired
	private IOfferLanguageService offerLanguageService;

	@Override
	public Offer addLanguage(Offer offer, OfferLanguage offerLanguage) {
		if (offer.getLanguages() == null)
			offer.setLanguages(new ArrayList<OfferLanguage>());
		if (!offer.getLanguages().contains(offerLanguage)) {
			offer.getLanguages().add(offerLanguage);
			return repository.save(offer);
		}
		return offer;
	}

	@Override
	public Offer save(Offer entity) {
		entity.setEnterprise(enterpriseService.findById(entity.getEnterprise().getId()));
		entity.setCategory(categoryService.findById(entity.getCategory().getId()));
		Offer offer = super.save(entity);
		List<OfferLanguage> offerLanguages = entity.getLanguages().stream().map(ol -> {
			return OfferLanguage.builder().language(languageService.findById(ol.getLanguage().getId()))
					.id(OfferLanguageKey.builder().languageId(ol.getLanguage().getId()).offerId(offer.getId()).build())
					.level(ol.getLevel()).offer(offer).build();
		}).collect(Collectors.toList());
		offerLanguageService.saveAll(offerLanguages);
		offer.setLanguages(offerLanguages);
		return offer;
	}

	// TODO: edit

	// TODO: filter

}
