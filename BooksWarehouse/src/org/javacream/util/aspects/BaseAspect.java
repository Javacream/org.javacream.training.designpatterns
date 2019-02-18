package org.javacream.util.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class BaseAspect implements InvocationHandler {

    private Object delegate;

    public void setDelegate(Object delegate) {
	this.delegate = delegate;
    }

    @Override
    public final Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	String methodName = method.getName();
	Object[] params = before(methodName, args);
	try {
	    Object result = method.invoke(delegate, params);
	    result = returning(methodName, params, result);
	    return result;
	} catch (Throwable t) {
	    if (t instanceof InvocationTargetException) {
		InvocationTargetException ite = (InvocationTargetException) t;
		t = ite.getTargetException();
	    }
	    t = throwing(methodName, params, t);
	    throw t;
	}
    }

    protected abstract Throwable throwing(String methodName, Object[] args, Throwable t);

    protected abstract Object returning(String methodName, Object[] args, Object result);

    protected abstract Object[] before(String methodName, Object[] args);

}
