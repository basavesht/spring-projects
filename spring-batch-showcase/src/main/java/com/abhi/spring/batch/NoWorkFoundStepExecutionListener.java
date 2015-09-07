package com.abhi.spring.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

public class NoWorkFoundStepExecutionListener extends StepExecutionListenerSupport {

	public ExitStatus afterStep(StepExecution stepExecution) {
		if (stepExecution.getReadCount() == 0) {
			return ExitStatus.FAILED;
		}
		return null;
	}
}
