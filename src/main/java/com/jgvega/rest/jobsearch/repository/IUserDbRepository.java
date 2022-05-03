package com.jgvega.rest.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgvega.rest.jobsearch.commons.entity.UserDb;

public interface IUserDbRepository<E extends UserDb, I> extends JpaRepository<E, I> {

}
