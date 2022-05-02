package com.jgvega.rest.jobsearch.controller;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgvega.rest.jobsearch.commons.controller.CommonController;
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.service.ICategoryService;

@RestController
@RequestMapping("/category")
@Profile("rest")
public class CategoryController extends CommonController<Category, Long, ICategoryService> {

	@GetMapping("/filter")
	public ResponseEntity<List<Category>> filterCategory(@RequestParam(required = false) String name,
			@RequestParam(required = false) String description) {
		Category category=Category.builder().build();
		if(name!=null && !name.isBlank())
			category.setName(name);
		if(description!=null && !description.isBlank())
			category.setDescription(description);
		return ResponseEntity.status(HttpStatus.FOUND).body(service.filter(category));
	}

}
