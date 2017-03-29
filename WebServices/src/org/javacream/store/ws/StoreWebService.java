package org.javacream.store.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.javacream.store.impl.adapter.CustomStoreServiceAdapter;
import org.javacream.util.net.HostUtil;

@WebService(targetNamespace = "http://services.javacream.org/store")
public class StoreWebService {

	private CustomStoreServiceAdapter storeService;
	
	{
		storeService = new CustomStoreServiceAdapter();
	}
	@WebMethod(operationName = "RetrieveStock")
	public @WebResult(name = "Stock") int stock(@WebParam(name = "Category") String category,
			@WebParam(name = "ItemId") String id) {
		return storeService.getStock(category, id);
	}

	public static void main(String[] args) {
		Endpoint.publish("http://" + HostUtil.getHost() + ":9900/StoreWebService", new StoreWebService());
	}

}
