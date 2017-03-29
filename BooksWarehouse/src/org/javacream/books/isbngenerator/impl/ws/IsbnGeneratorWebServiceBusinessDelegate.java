package org.javacream.books.isbngenerator.impl.ws;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.isbngenerator.ws.client.IsbnGeneratorWebService;
import org.javacream.isbngenerator.ws.client.IsbnGeneratorWebServiceService;

public class IsbnGeneratorWebServiceBusinessDelegate implements IsbnGenerator{

	private IsbnGeneratorWebService isbnGeneratorWebService;
	
	{
		isbnGeneratorWebService = new IsbnGeneratorWebServiceService().getIsbnGeneratorWebServicePort();
	}
	@Override
	public String next() {
		return isbnGeneratorWebService.generateNextIsbn();
	}


	
}
