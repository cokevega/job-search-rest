package com.jgvega.rest.jobsearch.enumeration;

public enum OfferStatus {
	CREATED {
		@Override
		public String toString() {
			return "Created";
		}
	}, ACTIVE {
		@Override
		public String toString() {
			return "Active";
		}
	}, INACTIVE {
		@Override
		public String toString() {
			return "Inactive";
		}
	}, DELETED {
		@Override
		public String toString() {
			return "Deleted";
		}
	};
}
