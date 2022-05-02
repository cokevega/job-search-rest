package com.jgvega.rest.jobsearch.commons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping("/create")
	public ResponseEntity<E> create(@RequestBody E entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<E> edit(@PathVariable I id, @RequestBody E newEntity) {
		E oldEntity=service.findById(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(oldEntity, newEntity));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable I id) {
		return ResponseEntity.status(HttpStatus.FOUND).build();
	}

}
