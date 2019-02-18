package org.javacream.util.aspects.impl;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.util.aspects.BaseAspect;

public class SerializingAspect extends BaseAspect {

    @Override
    protected Object[] before(String methodName, Object[] params) {
	return SerializationUtils.clone(params);
    }

    @Override
    protected Throwable throwing(String methodName, Object[] params, Throwable t) {
	return SerializationUtils.clone(t);
    }

    @Override
    protected Object returning(String methodName, Object[] params, Object result) {
	return SerializationUtils.clone((Serializable)result);
    }

}
