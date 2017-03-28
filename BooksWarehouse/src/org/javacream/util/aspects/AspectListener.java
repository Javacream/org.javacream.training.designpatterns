package org.javacream.util.aspects;


public interface AspectListener {
	void throwing(String methodName, Object[] args, Throwable t);

	void returning(String methodName, Object[] args, Object result);

	void before(String methodName, Object[] args);

}
