package org.javacream.util.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;

public final class Aspect implements InvocationHandler {
	private Object delegate;

	public void setDelegate(Object delegate) {
		this.delegate = delegate;
	}

	private List<AspectListener> listeners;

	public void setListeners(List<AspectListener> listeners) {
		this.listeners = listeners;
	}

	@Override
	public final Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		Object[] arguments = args;
		for (AspectListener aspectListener : listeners) {
			arguments = aspectListener.before(methodName, arguments);
		}
		try {
			Object result = method.invoke(delegate, arguments);
			for (AspectListener aspectListener : listeners) {
				result = aspectListener.returning(methodName, arguments, result);
			}
			return result;
		} catch (InvocationTargetException ite) {
			Throwable t = ite.getTargetException();
			for (AspectListener aspectListener : listeners) {
				t = aspectListener.throwing(methodName, arguments, t);
			}
			throw t;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T addAspect(T delegate, AspectListener... aspectListeners) {
		Aspect aspect = new Aspect();
		aspect.setDelegate(delegate);
		aspect.setListeners(Arrays.asList(aspectListeners));
		List<Class<?>> interfaces = ClassUtils.getAllInterfaces(delegate.getClass());
		Class<?>[] interfacesArray = new Class[interfaces.size()];
		interfaces.toArray(interfacesArray);
		ClassLoader cl = delegate.getClass().getClassLoader();
		Object proxy = Proxy.newProxyInstance(cl, interfacesArray, aspect);
		return (T) proxy;
	}

}
