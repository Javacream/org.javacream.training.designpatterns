package org.javacream.util.aspects.impl;

import org.javacream.util.aspects.AspectListener;

public abstract class BaseAspectListener implements AspectListener{

    @Override
    public Throwable throwing(String methodName, Object[] args, Throwable t) {
	return t;
    }

    @Override
    public Object returning(String methodName, Object[] args, Object result) {
	return result;
    }

    @Override
    public Object[] before(String methodName, Object[] args) {
	return args;
    }

}
