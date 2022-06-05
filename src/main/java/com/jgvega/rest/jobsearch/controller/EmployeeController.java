package com.jgvega.rest.jobsearch.controller;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.entity.Language;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.model.request.EmployeeFilterRequest;
import com.jgvega.rest.jobsearch.service.IEmployeeService;

@RestController
@Profile("rest")
@RequestMapping("/employee")
public class EmployeeController extends UserDbController<Employee, Long, IEmployeeService> {

	@GetMapping("/filter")
	public ResponseEntity<List<Employee>> filterEmployee(@RequestParam(required = false) String name,
			@RequestParam(required = false) String email, @RequestParam(required = false) UserStatus status,
			@RequestParam(required = false) Integer minAge, @RequestParam(required = false) Integer maxAge,
			@RequestParam(required = false) List<EmployeeLanguage> languages,
			@RequestParam(required = false) List<String> keywords) {
		if (minAge != null || maxAge != null || (keywords != null && !keywords.isEmpty())
				|| (languages != null && !languages.isEmpty())) {
			EmployeeFilterRequest employee = EmployeeFilterRequest.builder().email(email).keywords(keywords)
					.languages(languages).maxAge(maxAge).minAge(minAge).name(name).status(status).build();
			return ResponseEntity.ok(service.filterEmployeeUsingKeywordsOrAge(employee));
		}
		Employee employee = Employee.builder().email(email).status(status).name(name).build();
		return ResponseEntity.ok(service.filter(employee));
	}

}
