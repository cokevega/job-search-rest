package com.jgvega.rest.jobsearch.util;

public class Constant {
	//TODO: refactor this class
	/**
	 * Global
	 */
	public static final int EXIT_SUCCESS_STATUS = 0;
	/**
	 * Work model
	 */
	public static final String REMOTE = "Remote";
	public static final String HYBRID = "Hybrid";
	public static final String OFFICE = "Office";
	/**
	 * Level
	 */
	public static final String LOW = "Low";
	public static final String MEDIUM = "Medium";
	public static final String HIGH = "High";
	public static final String EXPERT = "Expert";
	/**
	 * Education level
	 */
	public static final String NONE = "None";
	public static final String HIGH_SCHOOL = "High school";
	public static final String VOCATIONAL_TRAINING = "Vocational training";
	public static final String DEGREE = "Degree";
	/**
	 * Application status
	 */
	public static final String UNKNOWN = "Unknown";
	public static final String ACCEPTED = "Accepted";
	public static final String REJECTED = "Rejected";
	/**
	 * Offer/UserDb status
	 */
	public static final String CREATED = "Created";
	public static final String ACTIVE = "Active";
	public static final String INACTIVE = "Inactive";
	public static final String DELETED = "Deleted";
	/**
	 * Global
	 */
	public static final int FAKE_YEARS_APP = 5;
	public static final int MAX_LENGTH_CITY = 100;
	public static final int MAX_LENGTH_NAME = 100;
	/**
	 * Category
	 */
	public static final int CATEGORY_NUMBER = 20;
	public static final int MIN_CHARACTERS_CATEGORY_DESCRIPTION = 10;
	public static final int MAX_CHARACTERS_CATEGORY_DESCRIPTION = 512;
	/**
	 * Offer
	 */
	public static final int OFFER_NUMBER = 300;
	public static final int MIN_CHARACTERS_OFFER_DESCRIPTION = 50;
	public static final int MAX_CHARACTERS_OFFER_DESCRIPTION = 1024;
	public static final int MAX_LENGTH_OFFER_LOCATION = 128;
	public static final int MIN_MAX_SALARY = 10000;
	public static final int MAX_MAX_SALARY = 60000;
	/**
	 * UserDb
	 */
	public static final int MAX_LENGTH_EMAIL = 100;
	public static final int MIN_LENGTH_PASSWORD = 5;
	public static final int MAX_LENGTH_PASSWORD = 100;
	/**
	 * Enterprise
	 */
	public static final int ENTERPRISE_NUMBER = 50;
	public static final int MAX_LENGTH_ENTERPRISE_DESCRIPTION = 2048;
	public static final int SENTENCES_ENTERPRISE_DESCRIPTION = 20;
	/**
	 * Employee
	 */
	public static final int EMPLOYEE_NUMBER = 300;
	public static final int MIN_AGE = 18;
	public static final int MAX_AGE = 65;
	public static final int MIN_PHONE_LENGTH = 9;
	public static final int MAX_PHONE_LENGTH = 16;
	/**
	 * Education
	 */
	public static final int EDUCATION_NUMBER = 600;
	public static final int MIN_LENGTH_CENTER = 10;
	public static final int MAX_LENGTH_CENTER = 100;
	/**
	 * Experience
	 */
	public static final int EXPERIENCE_NUMBER = 800;
	public static final int MAX_LENGTH_COMMENTS = 512;
	/**
	 * Skill
	 */
	public static final int SKILL_NUMBER = 1000;
	/**
	 * Language
	 */
	public static final int EMPLOYEE_LANGUAGE_NUMBER = EMPLOYEE_NUMBER * 2;
	public static final int OFFER_LANGUAGE_NUMBER = OFFER_NUMBER * 2;
	/**
	 * Application
	 */
	public static final int APPLICATION_NUMBER = OFFER_NUMBER * 3;
	public static final int MAX_LENGTH_APPLICATION_COMMENTS = 2048;
	public static final int SENTENCES_APPLICATION_COMMENTS = 20;
	/*
	 * Bad request
	 */
	public static final String MESSAGE_BAD_REQUEST = "Malformed request";
	/**
	 * Constraint violation exception
	 */
	public static final String TYPE_CONSTRAINT_VIOLATION_EXCEPTION = "ConstraintViolationException type";
	public static final String INSTANCE_CONSTRAINT_VIOLATION_EXCEPTION = "ConstraintViolationException instance";
	/**
	 * Entity not found exception
	 */
	public static final String TYPE_ENTITY_NOT_FOUND_EXCEPTION = "EntityNotFoundException type";
	public static final String INSTANCE_ENTITY_NOT_FOUND_EXCEPTION = "EntityNotFoundException instance";
	public static final String TITLE_ENTITY_NOT_FOUND_EXCEPTION = "Entity could not be found";
	public static final String DETAIL_ENTITY_NOT_FOUND_EXCEPTION = "Not found the entity with the specified parameters";
	/**
	 * Method argument type mismatch exception
	 */
	public static final String TYPE_METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION="MethodArgumentTypeMismatchException type";
	public static final String INSTANCE_METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION="MethodArgumentTypeMismatchException instance";
	/**
	 * SQL integrity constraint violation exception
	 */
	public static final String TYPE_SQL_INTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION = "SQLIntegrityConstraintViolationException type";
	public static final String INSTANCE_SQL_INTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION = "SQLIntegrityConstraintViolationException instance";
	
}
