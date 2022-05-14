package com.jgvega.rest.jobsearch.controller;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgvega.rest.jobsearch.commons.controller.CommonController;
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.enumeration.EducationLevel;
import com.jgvega.rest.jobsearch.enumeration.OfferStatus;
import com.jgvega.rest.jobsearch.enumeration.WorkModel;
import com.jgvega.rest.jobsearch.service.IOfferService;

@RestController
@Profile("rest")
@RequestMapping("/offer")
public class OfferController extends CommonController<Offer, Long, IOfferService> {

	@GetMapping("/filter")
	public ResponseEntity<List<Offer>> filterOffers(@RequestParam(required = false) String name,
			@RequestParam(required = false) String description, @RequestParam(required = false) OfferStatus status,
			@RequestParam(required = false) Integer minSalary, @RequestParam(required = false) Integer maxSalary,
			@RequestParam(required = false) WorkModel model, @RequestParam(required = false) Long enterprise,
			@RequestParam(required = false) Long category,
			@RequestParam(required = false) EducationLevel minEducationLevel) {
		Offer offer = Offer.builder().category(Category.builder().id(category).build()).description(description)
				.enterprise(Enterprise.builder().id(enterprise).build()).maxSalary(maxSalary).name(name)
				.minEducationLevel(minEducationLevel).minSalary(minSalary).model(model).status(status).build();
		return ResponseEntity.ok(service.filter(offer));
	}

}