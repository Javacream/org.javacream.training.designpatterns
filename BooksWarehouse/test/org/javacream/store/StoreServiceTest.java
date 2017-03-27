package org.javacream.store;

import org.javacream.store.impl.DummyStoreService;
import org.junit.Before;
import org.junit.Test;

public class StoreServiceTest {

	private DummyStoreService storeService;

	@Before public void setUp(){
		storeService = new DummyStoreService();
	}
	
	@Test public void storeRequestIsOk(){
		storeService.getStock("category", "item");
	}
}
