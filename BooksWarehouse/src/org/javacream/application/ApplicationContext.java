package org.javacream.application;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DummyStoreService;

public abstract class ApplicationContext {

	private static IsbnGenerator isbnGenerator;
	private static MapBooksService booksService;

	static {
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		randomIsbnGenerator.setPrefix("ISBN:");
		randomIsbnGenerator.setCountryCode("-dk");
		isbnGenerator = randomIsbnGenerator;
		MapBooksService mapBooksService = new MapBooksService();
		mapBooksService.setIsbnGenerator(isbnGenerator);
		mapBooksService.setStoreService(storeService());
		booksService = mapBooksService;

	}

	public static BooksService booksService() {
		return booksService;
	}
	
	public static IsbnGenerator isbnGenerator() {
		return isbnGenerator;
	}

	public static StoreService storeService() {
		// Method Scoped, just as an example...
		return new DummyStoreService();
	}

}
