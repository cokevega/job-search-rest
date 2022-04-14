package com.jgvega.rest.jobsearch.enumeration;

import com.jgvega.rest.jobsearch.util.Constant;

public enum Level {
	LOW {
		@Override
		public String toString() {
			return Constant.LOW;
		}
	},
	MEDIUM {
		@Override
		public String toString() {
			return Constant.MEDIUM;
		}
	},
	HIGH {
		@Override
		public String toString() {
			return Constant.HIGH;
		}
	},
	EXPERT {
		@Override
		public String toString() {
			return Constant.EXPERT;
		}
	};
}
