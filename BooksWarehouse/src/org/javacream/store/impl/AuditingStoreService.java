package org.javacream.store.impl;

import java.util.Date;

//Possible, but not such a good idea: extending a dummy...
public class AuditingStoreService extends DummyStoreService {

	@Override
	public int getStock(String catregory, String item) {
		System.out.println("getStock at " + new Date());
		int result = super.getStock(catregory, item);
		
		return result;
	}

}
