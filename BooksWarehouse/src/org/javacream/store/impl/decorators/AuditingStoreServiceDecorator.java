package org.javacream.store.impl.decorators;

import java.util.Date;

import org.javacream.store.api.StoreService;

public class AuditingStoreServiceDecorator implements StoreService{
	
	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	@Override
	public int getStock(String catregory, String item) {
		System.out.println("Decorator: getStock at " + new Date());
		int result = storeService.getStock(catregory, item);
		
		return result;
	}

}
