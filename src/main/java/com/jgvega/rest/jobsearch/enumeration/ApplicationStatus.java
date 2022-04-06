package com.jgvega.rest.jobsearch.enumeration;

public enum ApplicationStatus {
	UNKNOWN {
		@Override
		public String toString() {
			return "Unknown";
		}
	}, ACCEPTED {
		@Override
		public String toString() {
			return "Accepted";
		}
	}, REJECTED {
		@Override
		public String toString() {
			return "Rejected";
		}
	};
}
