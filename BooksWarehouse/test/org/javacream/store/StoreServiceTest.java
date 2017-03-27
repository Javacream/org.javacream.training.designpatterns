package org.javacream.store;

import org.junit.Before;
import org.junit.Test;

public class StoreServiceTest {

	private StoreService storeService;

	@Before public void setUp(){
		storeService = new StoreService();
	}
	
	@Test public void storeRequestIsOk(){
		storeService.getStock("category", "item");
	}
}
