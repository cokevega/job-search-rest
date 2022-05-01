package com.jgvega.rest.jobsearch.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgvega.rest.jobsearch.commons.controller.CommonController;
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.service.ICategoryService;

@RestController
@RequestMapping("/category")
@Profile("rest")
public class CategoryController extends CommonController<Category, Long, ICategoryService> {

	@PutMapping("/edit/{id}")
	public ResponseEntity<Category> edit(@PathVariable Long id, @RequestBody Category entity) {
		Category category = service.findById(id);
		return ResponseEntity.ok(service.edit(category, entity));
	}

}
