package org.javacream.books.isbngenerator.impl.ws;

import java.util.LinkedList;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.isbngenerator.fetch.ws.client.FetchingIsbnGeneratorWebService;
import org.javacream.isbngenerator.fetch.ws.client.FetchingIsbnGeneratorWebServiceService;

public class FetchingIsbnGeneratorWebServiceBusinessDelegate implements IsbnGenerator {

	private FetchingIsbnGeneratorWebService delegate;
	
	{
		delegate = new FetchingIsbnGeneratorWebServiceService().getFetchingIsbnGeneratorWebServicePort();
	}
	private LinkedList<String> isbns = new LinkedList<>();
	private int fetchSize;

	public void setFetchSize(int delay) {
		this.fetchSize = delay;
	}

	public void setDelegate(FetchingIsbnGeneratorWebService delegate) {
		this.delegate = delegate;
	}

	@Override
	public String next() {
		if (isbns.size() == 0) {
			isbns.addAll(delegate.generateNextIsbn(fetchSize));
		}
		return isbns.removeFirst();
	}

}
