package org.javacream.util.aspects.impl;

import org.javacream.util.aspects.AspectListener;

public class TracingAspectListener implements AspectListener{
	@Override
	public Throwable throwing(String methodName, Object[] args, Throwable t) {
		System.out.println("throwing from  " + methodName + ", throwable=" + t);
		return t;
	}

	@Override
	public Object returning(String methodName, Object[] args, Object result) {
		System.out.println("returning from  " + methodName + ", result=" + result);
		return result;
	}

	@Override
	public Object[] before(String methodName, Object[] args) {
		System.out.println("entering " + methodName);
		return args;
	}

}
