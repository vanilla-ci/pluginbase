package com.vanillaci.plugins;

/**
 * Created by joeljohnson on 11/26/14.
 */
public enum WorkStatus {
	/**
	 * Everything is happy and normal.
	 *
	 * @since 0.0.1
	 */
	SUCCESS(0),

	/**
	 * The WorkStep or Interceptor completed, but there were problems detected.
	 * i.e. a test case failed, the work step took longer than a user-defined threshold, etc.
	 *
	 * @since 0.0.1
	 */
	ERROR(1),

	/**
	 * The WorkStep did not complete. Either a bad state was detected or an unexpected exception was caught.
	 * Typically indicates there is a problem in configuration or in connecting to an external source.
	 * i.e. Git server was unreachable. Invalid revision specified. etc.
	 *
	 * @since 0.0.1
	 */
	UNEXPECTED_ERROR(2);

	private final int severity;

	private WorkStatus(int severity) {
		this.severity = severity;
	}

	public boolean isMoreSevereThan(WorkStatus other) {
		if(other == null) {
			throw new NullPointerException("other");
		}

		return this.severity > other.severity;
	}

	public boolean isLessSevereThan(WorkStatus other) {
		if(other == null) {
			throw new NullPointerException("other");
		}

		return this.severity < other.severity;
	}

	public boolean isMoreSevereThanOrEqualTo(WorkStatus other) {
		if(other == null) {
			throw new NullPointerException("other");
		}

		return this.severity >= other.severity;
	}

	public boolean isLessSevereThanOrEqualTo(WorkStatus other) {
		if(other == null) {
			throw new NullPointerException("other");
		}

		return this.severity <= other.severity;
	}
}
