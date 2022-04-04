package com.jgvega.rest.jobsearch.enumeration;

import java.io.Serializable;

import com.jgvega.rest.jobsearch.constant.Constant;

public enum EducationLevel implements Serializable {
	NONE {
		@Override
		public String toString() {
			return Constant.NONE;
		}
	},
	HIGH_SCHOOL {
		@Override
		public String toString() {
			return Constant.HIGH_SCHOOL;
		}
	},
	VOCATIONAL_TRAINING {
		@Override
		public String toString() {
			return Constant.VOCATIONAL_TRAINING;
		}
	},
	DEGREE {
		@Override
		public String toString() {
			return Constant.DEGREE;
		}
	},
}
