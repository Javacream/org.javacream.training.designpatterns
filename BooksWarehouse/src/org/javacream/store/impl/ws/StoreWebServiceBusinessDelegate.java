package org.javacream.store.impl.ws;

import org.javacream.store.api.StoreService;
import org.javacream.store.ws.client.StoreWebService;
import org.javacream.store.ws.client.StoreWebServiceService;

public class StoreWebServiceBusinessDelegate implements StoreService{
	private StoreWebService storeWebService;
	
	{
		storeWebService = new StoreWebServiceService().getStoreWebServicePort();
	}

	@Override
	public int getStock(String category, String item) {
		return storeWebService.retrieveStock(category, item);
	}
}
