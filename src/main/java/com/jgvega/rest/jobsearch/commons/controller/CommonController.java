package com.jgvega.rest.jobsearch.commons.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jgvega.rest.jobsearch.commons.service.ICommonService;

public class CommonController<E, I, S extends ICommonService<E, I>> {

	@Autowired
	protected S service;

	@GetMapping("/all")
	public ResponseEntity<List<E>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<E> findById(@PathVariable I id) {
		Optional<E> op = service.findById(id);
		if (op.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(op.get());
	}

	@PostMapping("/create")
	public ResponseEntity<E> create(@RequestBody E entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable I id) {
		return ResponseEntity.status(HttpStatus.FOUND).build();
	}

}
