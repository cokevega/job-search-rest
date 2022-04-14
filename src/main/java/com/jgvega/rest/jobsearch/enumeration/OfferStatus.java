package com.jgvega.rest.jobsearch.enumeration;

import com.jgvega.rest.jobsearch.util.Constant;

public enum OfferStatus {
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
	},
	DELETED {
		@Override
		public String toString() {
			return Constant.DELETED;
		}
	};
}
