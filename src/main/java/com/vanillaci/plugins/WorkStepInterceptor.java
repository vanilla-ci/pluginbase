package com.vanillaci.plugins;

/**
 * Called before any work step is executed. All WorkStepInterceptors are called in an undefined order.
 * All befores and all afters are always called for every work step, even if another before/after threw an exception or if the work has been terminated.
 *
 * Only one instance is used for all work being done, across all threads. Any implementation should not have state.
 *
 * @author Joel Johnson
 */
public interface WorkStepInterceptor {
	/**
	 * Called before every WorkStep.
	 *
	 * @param workContext Provides options for changing the properties, state, and status of the current job.
	 * @since 0.0.1
	 */
	void before(WorkContext workContext);

	/**
	 * Called after every WorkStep.
	 * @param workContext Provides options for changing the properties, state, and status of the current job.
	 * @since 0.0.1
	 */
	void after(WorkContext workContext);
}
