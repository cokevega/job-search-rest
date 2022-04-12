package com.jgvega.rest.jobsearch.constant;

import java.io.Serializable;

public class Constant implements Serializable {

	private static final long serialVersionUID = 7470825502615435206L;
	/**
	 * Work model
	 */
	public static final String REMOTE="Remote";
	public static final String HYBRID="Hybride";
	public static final String OFFICE="Office";
	/**
	 * Level
	 */
	public static final String LOW="Low";
	public static final String MEDIUM="Medium";
	public static final String HIGH="High";
	public static final String EXPERT="Expert";
	/**
	 * Education level
	 */
	public static final String NONE="None";
	public static final String HIGH_SCHOOL="High school";
	public static final String VOCATIONAL_TRAINING="Vocational training";
	public static final String DEGREE="Degree";
	/**
	 * Application status
	 */
	public static final String UNKNOWN="Unknown";
	public static final String ACCEPTED="Accepted";
	public static final String REJECTED="Rejected";
	/**
	 * Offer/UserDb status
	 */
	public static final String CREATED="Created";
	public static final String ACTIVE="Active";
	public static final String INACTIVE="Inactive";
	public static final String DELETED="Deleted";
	/**
	 * Global
	 */
	public static final int FAKE_YEARS_APP=5;
	/**
	 * Common model
	 */
	public static final int MAX_LENGTH_NAME=100;
	/**
	 * Category
	 */
	public static final int CATEGORY_NUMBER=20;
	public static final int MIN_CHARACTERS_CATEGORY_DESCRIPTION=10;
	public static final int MAX_CHARACTERS_CATEGORY_DESCRIPTION=512;
	/**
	 * Offer
	 */
	public static final int OFFER_NUMBER=300;
	public static final int MIN_CHARACTERS_OFFER_DESCRIPTION=50;
	public static final int MAX_CHARACTERS_OFFER_DESCRIPTION=1024;
	public static final int MAX_LENGTH_OFFER_LOCATION=128;
	/**
	 * UserDb
	 */
	public static final int MAX_LENGTH_EMAIL=100;
	public static final int MIN_LENGTH_PASSWORD=5;
	public static final int MAX_LENGTH_PASSWORD=100;
	/**
	 * Enterprise
	 */
	public static final int ENTERPRISE_NUMBER=50;
	public static final int MAX_LENGTH_ENTERPRISE_DESCRIPTION=2048;

}
