package org.javacream.util.aspects;

public class NoOpAspect extends BaseAspect{
	
	@Override
	protected void throwing(String methodName, Object[] args, Throwable t) {
	}

	@Override
	protected void returning(String methodName, Object result, Object result2) {
	}

	@Override
	protected void before(String methodName, Object[] args) {
	}
	
	public static <T> T addAspect(T delegate){
		NoOpAspect aspect = new NoOpAspect();
		aspect.setDelegate(delegate);
		return BaseAspect.addAspect(delegate, aspect);
	}

}
