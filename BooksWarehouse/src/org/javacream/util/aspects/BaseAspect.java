package org.javacream.util.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class BaseAspect implements InvocationHandler{

    	private Object delegate;
    	
	public void setDelegate(Object delegate) {
	    this.delegate = delegate;
	}

	@Override
	public final Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	    try {
		Object[] params = before(args);
		Object result = method.invoke(delegate, params);
		result = afterReturning(result);
		return result;
	    }
	    catch(Throwable t) {
		if (t instanceof InvocationTargetException) {
		    InvocationTargetException ite = (InvocationTargetException) t;
		    t = ite.getTargetException();
		}
		t = afterThrowing(t);
		throw t;
	    }
	}
	
	protected abstract Object[] before(Object[] args);
	protected abstract Throwable afterThrowing(Throwable t);
	protected abstract Object afterReturning(Object result);


}
