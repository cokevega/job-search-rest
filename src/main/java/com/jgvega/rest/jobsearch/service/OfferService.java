package com.jgvega.rest.jobsearch.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.model.entity.Offer;
import com.jgvega.rest.jobsearch.model.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.repository.IOfferRepository;

@Service
public class OfferService {
	
	@Autowired
	private IOfferRepository offerRepository;

	public Offer addLanguage(Offer offer, OfferLanguage offerLanguage) {
		if(offer.getLanguages()==null)
			offer.setLanguages(new ArrayList<OfferLanguage>());
		if(!offer.getLanguages().contains(offerLanguage)) {
			offer.getLanguages().add(offerLanguage);
			return offerRepository.save(offer);
		}
		return offer;
	}
	
}
