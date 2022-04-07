package com.jgvega.rest.jobsearch.enumeration;

import com.jgvega.rest.jobsearch.constant.Constant;

public enum UserStatus {
	CREATED {
		@Override
		public String toString() {
			return Constant.CREATED;
		}
	},
	ACTIVE {
		@Override
		public String toString() {
			return Constant.ACTIVE;
		}
	},
	INACTIVE {
		@Override
		public String toString() {
			return Constant.INACTIVE;
		}
	};
}
