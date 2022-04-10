package com.jgvega.rest.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgvega.rest.jobsearch.model.entity.Application;

@Repository
public interface IApplicationRepository extends JpaRepository<Application, Long> {

}
