package org.javacream.application;

import java.util.HashMap;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.impl.SimpleOrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DummyStoreService;
import org.javacream.util.IdGenerator;

public abstract class ApplicationContext {

	private static IsbnGenerator isbnGenerator;
	private static MapBooksService booksService;
	private static SimpleOrderService orderService;
	private static IdGenerator idGenerator;

	static {
		
		//Create Objects
		CounterIsbnGenerator isbnGeneratorImpl = new CounterIsbnGenerator();
		isbnGenerator = isbnGeneratorImpl;
		MapBooksService mapBooksService = new MapBooksService();
		booksService = mapBooksService;
		SimpleOrderService simpleOrderService = new SimpleOrderService();
		orderService = simpleOrderService;
		idGenerator = new IdGenerator();
		HashMap<String, Book> testData = new HashMap<>();
		for (int i = 0; i < 10; i++){
			String isbn = "ISBN" + i;
			Book book = new Book();
			book.setIsbn(isbn);
			book.setTitle("Title" + i);
			book.setPrice(3.99*i);
			testData.put(isbn, book);
		}

		//set Dependencies
		mapBooksService.setBooks(testData);
		mapBooksService.setIsbnGenerator(isbnGenerator);
		mapBooksService.setStoreService(storeService());

		simpleOrderService.setBooksService(mapBooksService);
		simpleOrderService.setIdGenerator(idGenerator);
		simpleOrderService.setStoreService(storeService());

		isbnGeneratorImpl.setPrefix("ISBN:");
		isbnGeneratorImpl.setCountryCode("-dk");

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

	public static OrderService orderService() {
		return orderService;
	}
	public static IdGenerator idGenerator() {
		return idGenerator;
	}

}
