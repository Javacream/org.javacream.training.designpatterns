package org.javacream.util.aspects;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

public class SerializingAspect extends BaseAspect {

    @Override
    protected Object[] before(Object[] args) {
	return SerializationUtils.clone(args);
    }

    @Override
    protected Throwable afterThrowing(Throwable t) {
	return t;
    }

    @Override
    protected Object afterReturning(Object result) {
	return SerializationUtils.clone((Serializable)result);
    }

}
