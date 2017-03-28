package org.javacream.util.aspects.impl;

import org.javacream.util.aspects.AspectListener;

public class TracingAspectListener implements AspectListener{
	@Override
	public void throwing(String methodName, Object[] args, Throwable t) {
		System.out.println("throwing from  " + methodName + ", throwable=" + t);
	}

	@Override
	public void returning(String methodName, Object[] args, Object result) {
		System.out.println("returning from  " + methodName + ", result=" + result);
	}

	@Override
	public void before(String methodName, Object[] args) {
		System.out.println("entering " + methodName);
	}

}
