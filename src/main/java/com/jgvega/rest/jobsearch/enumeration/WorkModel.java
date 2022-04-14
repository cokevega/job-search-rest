package com.jgvega.rest.jobsearch.enumeration;

import com.jgvega.rest.jobsearch.util.Constant;

public enum WorkModel {
	REMOTE {
		@Override
		public String toString() {
			return Constant.REMOTE;
		}
	},
	OFFICE {
		@Override
		public String toString() {
			return Constant.OFFICE;
		}
	},
	HYBRIDE {
		@Override
		public String toString() {
			return Constant.HYBRID;
		}
	};
}
