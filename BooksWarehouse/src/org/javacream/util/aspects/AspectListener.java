package org.javacream.util.aspects;


public interface AspectListener {
	Throwable throwing(String methodName, Object[] args, Throwable t);

	Object returning(String methodName, Object[] args, Object result);

	Object[] before(String methodName, Object[] args);

}
