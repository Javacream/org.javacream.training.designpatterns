package org.javacream.util.aspects;

public class TracingAspect extends BaseAspect {
	
	@Override
	protected void throwing(String methodName, Object[] args, Throwable t) {
		System.out.println("throwing from  " + methodName + ", throwable=" + t);
	}

	@Override
	protected void returning(String methodName, Object result, Object result2) {
		System.out.println("returning from  " + methodName + ", result=" + result);
	}

	@Override
	protected void before(String methodName, Object[] args) {
		System.out.println("entering " + methodName);
	}
	
}
