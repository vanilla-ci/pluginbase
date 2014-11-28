package com.vanillaci.plugins;

/**
 * Only one instance is used for all work being done, across all threads. Any implementation should not have state.
 *
 * @author Joel Johnson
 */
public interface WorkStep {
	/**
	 * Executes the step with the given context.
	 * @param workContext
	 * @since 0.0.1
	 */
	public void execute(WorkContext workContext);
}
