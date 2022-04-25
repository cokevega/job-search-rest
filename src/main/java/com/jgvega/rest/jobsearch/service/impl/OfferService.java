package com.jgvega.rest.jobsearch.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.repository.IOfferRepository;
import com.jgvega.rest.jobsearch.service.IOfferService;

@Service
public class OfferService extends CommonService<Offer, Long, IOfferRepository> implements IOfferService {

	public Offer addLanguage(Offer offer, OfferLanguage offerLanguage) {
		if(offer.getLanguages()==null)
			offer.setLanguages(new ArrayList<OfferLanguage>());
		if(!offer.getLanguages().contains(offerLanguage)) {
			offer.getLanguages().add(offerLanguage);
			return repository.save(offer);
		}
		return offer;
	}
	
}
