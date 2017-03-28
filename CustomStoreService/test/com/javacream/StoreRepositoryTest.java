package com.javacream;

import org.junit.Test;

public class StoreRepositoryTest {

	@Test public void testStoreRepository(){
		for (int i = 0; i < 10; i++){
			Request request = new Request("this", "that");
			Response response = StoreRepository.read(request);
			System.out.println(response.getAvailableItems());
		}
		
	}
}
