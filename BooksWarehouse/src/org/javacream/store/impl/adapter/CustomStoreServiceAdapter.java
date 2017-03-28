package org.javacream.store.impl.adapter;

import org.javacream.store.api.StoreService;

import com.javacream.Request;
import com.javacream.Response;
import com.javacream.StoreRepository;

public class CustomStoreServiceAdapter implements StoreService{

	@Override
	public int getStock(String category, String id) {
		Request request = new Request(category, id);
		Response response = StoreRepository.read(request);
		return response.getAvailableItems();
	}

	
}
