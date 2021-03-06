package com.jgvega.rest.jobsearch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
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

	// TODO: refactor how to save OfferLanguage?
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

	@Override
	public Offer edit(Long id, Offer newEntity) {
		Offer oldEntity = super.edit(id, newEntity);
		if (newEntity.getCategory().getId() != oldEntity.getCategory().getId())
			oldEntity.setCategory(categoryService.findById(newEntity.getCategory().getId()));
		oldEntity.setDescription(newEntity.getDescription());
		newEntity.getLanguages().stream().filter(ol -> !oldEntity.getLanguages().contains(OfferLanguage.builder()
				.id(OfferLanguageKey.builder().offerId(id).languageId(ol.getLanguage().getId()).build()).build()))
				.forEach(ol -> addLanguage(oldEntity,
						OfferLanguage.builder()
								.id(OfferLanguageKey.builder().offerId(id).languageId(ol.getLanguage().getId()).build())
								.language(ol.getLanguage()).level(ol.getLevel()).offer(oldEntity).build()));
		oldEntity.setLocation(newEntity.getLocation());
		oldEntity.setMaxSalary(newEntity.getMaxSalary());
		oldEntity.setMinEducationLevel(newEntity.getMinEducationLevel());
		oldEntity.setMinSalary(newEntity.getMinSalary());
		oldEntity.setModel(newEntity.getModel());
		oldEntity.setName(newEntity.getName());
		oldEntity.setStatus(newEntity.getStatus());
		return super.save(oldEntity);
	}

	@Override
	public List<Offer> filter(Offer entity) {
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase();
		Offer offer = Offer.builder().build();
		if (entity.getName() != null)
			offer.setName(entity.getName());
		if (entity.getDescription() != null)
			offer.setDescription(entity.getDescription());
		if (entity.getStatus() != null)
			offer.setStatus(entity.getStatus());
		if (entity.getEnterprise() != null)
			offer.setEnterprise(entity.getEnterprise());
		if (entity.getCategory() != null)
			offer.setCategory(entity.getCategory());
		if (entity.getModel() != null)
			offer.setModel(entity.getModel());
		if (entity.getMinEducationLevel() != null)
			offer.setMinEducationLevel(entity.getMinEducationLevel());
		List<Offer> offers = findByExample(Example.of(offer, exampleMatcher));
		if (entity.getMaxSalary() != null || entity.getMinSalary() != null) {
			offers = offers.stream().filter(o -> {
				if (entity.getMinSalary() != null && o.getMinSalary() < entity.getMinSalary())
					return false;
				if (entity.getMaxSalary() != null && o.getMaxSalary() > entity.getMaxSalary())
					return false;
				return true;
			}).toList();
		}
		return offers;
	}

}
