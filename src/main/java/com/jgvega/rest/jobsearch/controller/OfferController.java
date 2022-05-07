package com.jgvega.rest.jobsearch.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgvega.rest.jobsearch.commons.controller.CommonController;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.service.IOfferService;

@RestController
@Profile("rest")
@RequestMapping("/offer")
public class OfferController extends CommonController<Offer, Long, IOfferService> {

}