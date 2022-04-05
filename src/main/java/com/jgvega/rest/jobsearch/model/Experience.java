package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "experience")
public class Experience implements Serializable {

	private static final long serialVersionUID = 5814969490078999132L;

	private Long id;
	private String position;
	private String enterprise;
	private Date begin;
	private Date end;
	private String comments;
	private String city;

}
