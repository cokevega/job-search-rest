package com.jgvega.rest.jobsearch.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgvega.rest.jobsearch.commons.controller.CommonController;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;

@RestController
@Profile("rest")
@RequestMapping("/enterprise")
public class EnterpriseController extends CommonController<Enterprise, Long, IEnterpriseService> {

}
