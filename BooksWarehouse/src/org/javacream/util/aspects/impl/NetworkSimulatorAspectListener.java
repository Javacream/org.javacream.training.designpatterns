package org.javacream.util.aspects.impl;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.util.aspects.AspectListener;

public class NetworkSimulatorAspectListener implements AspectListener{

	private long delay;
	
	

	public NetworkSimulatorAspectListener(long delay) {
		this.delay = delay;
	}

	@Override
	public Object[] before(String methodName, Object[] args) {
		return SerializationUtils.clone(args);
	}

	@Override
	public Object returning(String methodName, Object[] args, Object result) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return SerializationUtils.clone((Serializable)result);
	}

	@Override
	public Throwable throwing(String methodName, Object[] args, Throwable t) {
		return SerializationUtils.clone(t);
	}

}
