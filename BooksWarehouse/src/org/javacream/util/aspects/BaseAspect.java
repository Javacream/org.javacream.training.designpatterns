package org.javacream.util.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;

public abstract class BaseAspect implements InvocationHandler {
	protected Object delegate;

	public void setDelegate(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public final Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		before(methodName, args);
		try {
			Object result = method.invoke(delegate, args);
			returning(methodName, args, result);
			return result;
		} catch (InvocationTargetException ite) {
			Throwable t = ite.getTargetException();
			throwing(methodName, args, t);
			throw t;
		}
	}

	protected abstract void throwing(String methodName, Object[] args, Throwable t);

	protected abstract void returning(String methodName, Object result, Object result2);

	protected abstract void before(String methodName, Object[] args);

	
	@SuppressWarnings("unchecked")
	public static <T> T addAspect(T delegate, InvocationHandler aspect){
		List<Class<?>> interfaces = ClassUtils.getAllInterfaces(delegate.getClass());
		Class<?>[] interfacesArray = new Class[interfaces.size()];
		interfaces.toArray(interfacesArray);
		ClassLoader cl = delegate.getClass().getClassLoader();
		Object proxy = Proxy.newProxyInstance(cl, interfacesArray, aspect);
		return (T) proxy;
	}

}
