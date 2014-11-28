package com.vanillaci.plugins;

/**
 * Called before/after any work.
 *
 * @author Joel Johnson
 * @since 0.0.1
 */
public interface WorkInterceptor {
	/**
	 * Called before any work starts.
	 * @param workContext
	 */
	void before(WorkContext workContext);

	/**
	 * Called after all the work has finished.
	 * @param workContext
	 */
	void after(WorkContext workContext);
}
