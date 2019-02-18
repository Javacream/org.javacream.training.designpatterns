package org.javacream.util.aspects.impl;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.util.aspects.AspectListener;

public class SerializingAspectListener implements AspectListener{
    @Override
    public Object[] before(String methodName, Object[] args) {
	return SerializationUtils.clone(args);
    }

    @Override
    public Throwable throwing(String methodName, Object[] params, Throwable t) {
	return SerializationUtils.clone(t);
    }

    @Override
    public Object returning(String methodName, Object[] params, Object result) {
	return SerializationUtils.clone((Serializable)result);
    }

}