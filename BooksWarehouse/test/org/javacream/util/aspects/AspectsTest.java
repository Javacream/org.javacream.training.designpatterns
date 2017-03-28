package org.javacream.util.aspects;

import java.util.ArrayList;
import java.util.List;

import org.javacream.application.ApplicationContext;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.Test;

public class AspectsTest {

	//@Test 
	public void testList(){
		List<String> names = new ArrayList<>();
		names = TracingAspect.addAspect(names);
		names.add("Hugo");
		names.add("Emil");
		names.add("Fritz");
		System.out.println(names.toString());
		
	}

	@Test 
	public void testListWithAspect(){
		List<String> names = new ArrayList<>();
		names = Aspect.addAspect(names, new AspectListener() {
			
			@Override
			public void throwing(String methodName, Object[] args, Throwable t) {
				System.out.println("throwing");
			}
			
			@Override
			public void returning(String methodName, Object[] args , Object result) {
				System.out.println("returning");
			}
			
			@Override
			public void before(String methodName, Object[] args) {
				System.out.println("before");
			}
		});
		names.add("Hugo");
		names.add("Emil");
		names.add("Fritz");
		System.out.println(names.toString());
		
	}

	
	@Test
	public void testIsbnGenerator(){
		IsbnGenerator generator = ApplicationContext.isbnGenerator();
		generator = TracingAspect.addAspect(generator);
		System.out.println(generator.next());
	}
//	@Test
	public void testAspectPerformance(){
		IsbnGenerator generator = ApplicationContext.isbnGenerator();
//		generator = NoOpAspect.addAspect(generator);
//		System.out.println(generator.next());
		for (int i = 0; i < 1000000; i++){
			generator.next();
		}
	}
}
