package com.jgvega.rest.jobsearch.controller;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;

@RestController
@Profile("rest")
@RequestMapping("/enterprise")
public class EnterpriseController extends UserDbController<Enterprise, Long, IEnterpriseService> {

	@GetMapping("/filter")
	public ResponseEntity<List<Enterprise>> filterEnterprise(@RequestParam(required = false) String name,
			@RequestParam(required = false) String email, @RequestParam(required = false) UserStatus status,
			@RequestParam(required = false) String description) {
		Enterprise enterprise = Enterprise.builder().description(description).email(email).name(name).status(status)
				.build();
		return ResponseEntity.ok(service.filter(enterprise));
	}

}
