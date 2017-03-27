package org.javacream.store;

import org.javacream.application.ApplicationContext;
import org.javacream.store.api.StoreService;
import org.junit.Before;
import org.junit.Test;

public class StoreServiceTest {

	private StoreService storeService;

	@Before public void setUp(){
		storeService = ApplicationContext.storeService();//new DummyStoreService();
	}
	
	@Test public void storeRequestIsOk(){
		storeService.getStock("category", "item");
	}
}
