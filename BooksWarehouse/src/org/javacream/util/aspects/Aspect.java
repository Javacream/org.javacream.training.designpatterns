package org.javacream.util.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;

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
		listener.before(methodName, args);
		try {
			Object result = method.invoke(delegate, args);
			listener.returning(methodName, args, result);
			return result;
		} catch (InvocationTargetException ite) {
			Throwable t = ite.getTargetException();
			listener.throwing(methodName, args, t);
			throw t;
		}
	}

	
	@SuppressWarnings("unchecked")
	public static <T> T addAspect(T delegate, AspectListener al){
		Aspect aspect = new Aspect();
		aspect.setDelegate(delegate);
		aspect.setListener(al);
		List<Class<?>> interfaces = ClassUtils.getAllInterfaces(delegate.getClass());
		Class<?>[] interfacesArray = new Class[interfaces.size()];
		interfaces.toArray(interfacesArray);
		ClassLoader cl = delegate.getClass().getClassLoader();
		Object proxy = Proxy.newProxyInstance(cl, interfacesArray, aspect);
		return (T) proxy;
	}

}
