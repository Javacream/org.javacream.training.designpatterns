package org.javacream.store.impl;

import org.javacream.store.api.StoreService;

public class DummyStoreService implements StoreService {

	/* (non-Javadoc)
	 * @see org.javacream.store.impl.StoreService#getStock(java.lang.String, java.lang.String)
	 */
	@Override
	public int getStock(String catregory, String item){
		//retrieve stock from external service, e.g. web service call...
		return 42;
	}
}
