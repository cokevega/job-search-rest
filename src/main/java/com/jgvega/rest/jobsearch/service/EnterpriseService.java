package com.jgvega.rest.jobsearch.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.model.entity.Enterprise;
import com.jgvega.rest.jobsearch.model.entity.Offer;
import com.jgvega.rest.jobsearch.repository.IEnterpriseRepository;

@Service
public class EnterpriseService {

	@Autowired
	private IEnterpriseRepository enterpriseRepository;

	public void addOffer(Enterprise enterprise, Offer offer) {
		if (null == enterprise.getOffers())
			enterprise.setOffers(new ArrayList<Offer>());
		enterprise.getOffers().add(offer);
		enterpriseRepository.save(enterprise);
	}

}
