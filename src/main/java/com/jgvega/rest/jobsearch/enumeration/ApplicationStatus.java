package com.jgvega.rest.jobsearch.enumeration;

import com.jgvega.rest.jobsearch.util.Constant;

public enum ApplicationStatus {
	UNKNOWN {
		@Override
		public String toString() {
			return Constant.UNKNOWN;
		}
	}, ACCEPTED {
		@Override
		public String toString() {
			return Constant.ACCEPTED;
		}
	}, REJECTED {
		@Override
		public String toString() {
			return Constant.REJECTED;
		}
	};
}
