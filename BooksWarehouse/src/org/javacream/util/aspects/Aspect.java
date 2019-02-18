package org.javacream.util.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Aspect implements InvocationHandler {
	private Object delegate;

	public void setDelegate(Object delegate) {
		this.delegate = delegate;
	}
	
	private AspectListener listener;

	public void setListener(AspectListener listener) {
		this.listener = listener;
	}


	@Override
	public final Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		Object[] params = listener.before(methodName, args);
		try {
			Object result = method.invoke(delegate, args);
			result = listener.returning(methodName, params, result);
			return result;
		} catch (InvocationTargetException ite) {
			Throwable t = ite.getTargetException();
			t = listener.throwing(methodName, params, t);
			throw t;
		}
	}

}
