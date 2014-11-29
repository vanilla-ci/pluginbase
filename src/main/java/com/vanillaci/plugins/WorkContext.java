package com.vanillaci.plugins;

import java.io.*;

/**
 * @author Joel Johnson
 */
public interface WorkContext {
	String getWorkId();

	/**
	 * @return the value for the given parameter, if it exists. Otherwise returns null.
	 * 			Parameters added through {@link #addParameter(String, String)} have precedence.
	 * 			Parameters defined for the current WorkStep have next order of precedence.
	 * 			Parameters defined for the Work have the lowest level of precedence.
	 * @since 0.0.1
	 */
	String getParameter(String parameterName);

	/**
	 * Adds the given parameter to the parameter map for current and future work steps.
	 * @since 0.0.1
	 */
	void addParameter(String parameterName, String parameterValue);


	/**
	 * @return The work step that's going to be run.
	 * 			From the context of a WorkStep's execute method, WorkContext.getWorkStep() == this.
	 * @since 0.0.1
	 */
	WorkStep getWorkStep();

	/**
	 * Override the workStep that's about to run. Obviously, calling this will only have effect if it's called before the
	 * work step is run. For example, calling it from {@link com.vanillaci.plugins.WorkStepInterceptor#after} will have no effect.
	 *
	 * @param workStep The workStep that should execute.
	 * @since 0.0.1
	 */
	void setWorkStep(WorkStep workStep);

	/**
	 * @return the current status of the overall work.
	 * @since 0.0.1
	 */
	WorkStatus getWorkStatus();

	/**
	 * Sets the current status to the given value, if the given value is more severe than the current status.
	 * @param workStatus The desired status of the job.
	 * @since 0.0.1
	 */
	void setWorkStatus(WorkStatus workStatus);

	/**
	 * Sets the current status to the given value regardless of the current status.
	 * @param workStatus The desired status of the job.
	 * @since 0.0.1
	 */
	void overrideWorkStatus(WorkStatus workStatus);

	/**
	 * Whether or not the work needs to stop running, regardless of the number of steps remaining.
	 * Even if this is true, all post-steps will attempt to run.
	 * @return True if the work is set to terminate
	 * @since 0.0.1
	 */
	boolean getTerminate();

	/**
	 * Sets the work to terminate, reglardless of the number of steps remaining.
	 * Even if this is true, all post-steps will attempt to run.
	 * @param terminate
	 * @since 0.0.1
	 */
	void setTerminate(boolean terminate);

	/**
	 * @return the current step number of the current state.
	 * @since 0.0.1
	 */
	int getCurrentStep();

	/**
	 * @return the number of steps that will be executed in the current state.
	 * @since 0.0.1
	 */
	int getTotalSteps();

	/**
	 * @return the current step number of the current state.
	 * @since 0.0.1
	 */
	int getCurrentPostStep();

	/**
	 * @return the number of steps that will be executed in the current state.
	 * @since 0.0.1
	 */
	int getTotalPostSteps();

	/**
	 * @return Where in the build process the work currently is.
	 * @since 0.0.1
	 */
	WorkPhase getWorkPhase();

	/**
	 * @return An existing directory representing the working directory of the work.
	 * Generally, any files created should be put in this directory.
	 * Any commands run should use this directory as the working directory.
	 * @since 0.0.1
	 */
	File getWorkingDirectory();
}
