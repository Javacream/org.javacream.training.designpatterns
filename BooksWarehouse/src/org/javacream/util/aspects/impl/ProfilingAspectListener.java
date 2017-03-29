package org.javacream.util.aspects.impl;

import org.javacream.util.aspects.AspectListener;

public class ProfilingAspectListener implements AspectListener{

	long start;

	@Override
	public Object[] before(String methodName, Object[] args) {
		start = System.currentTimeMillis();
		return args;
	}

	@Override
	public Object returning(String methodName, Object[] args, Object result) {
		profile(methodName);
		return result;
	}

	@Override
	public Throwable throwing(String methodName, Object[] args, Throwable t) {
		profile(methodName);
		return t;
	}

	private void profile(String methodName){
		System.out.println("LISTENER: " + methodName + " took " + (System.currentTimeMillis() - start));
	}
}
