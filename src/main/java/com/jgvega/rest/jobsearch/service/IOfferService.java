package com.jgvega.rest.jobsearch.service;

import com.jgvega.rest.jobsearch.commons.service.ICommonService;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;

public interface IOfferService extends ICommonService<Offer, Long> {

	public Offer addLanguage(Offer offer, OfferLanguage offerLanguage);

}
