package org.javacream.application;

import java.util.ArrayList;
import java.util.HashMap;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.impl.SimpleOrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.event.BookEventListener;
import org.javacream.books.warehouse.api.event.BookEventSupport;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.books.warehouse.impl.decorators.EventBooksService;
import org.javacream.books.warehouse.impl.decorators.SerializingBooksService;
import org.javacream.books.warehouse.impl.decorators.ValidatingBooksService;
import org.javacream.books.warehouse.impl.event.SimpleBookEventListener;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.AuditingStoreService;
import org.javacream.store.impl.decorators.AuditingStoreServiceDecorator;
import org.javacream.util.IdGenerator;

public abstract class ApplicationContext {

	private static IsbnGenerator isbnGenerator;
	private static BooksService booksService;
	private static SimpleOrderService orderService;
	private static IdGenerator idGenerator;

	static {

		// Create Objects
		CounterIsbnGenerator isbnGeneratorImpl = new CounterIsbnGenerator();
		MapBooksService mapBooksService = new MapBooksService();
		SimpleOrderService simpleOrderService = new SimpleOrderService();
		HashMap<String, Book> testData = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			String isbn = "ISBN" + i;
			Book book = new Book();
			book.setIsbn(isbn);
			book.setTitle("Title" + i);
			book.setPrice(3.99 * i);
			testData.put(isbn, book);
		}

		IdGenerator theIdGenerator = new IdGenerator();
		ValidatingBooksService validatingBooksService = new ValidatingBooksService();
		SerializingBooksService serializingBooksService = new SerializingBooksService();
		EventBooksService notifyingBooksService = new EventBooksService();
		
		BookEventSupport bookNotificationSupport = new BookEventSupport();
		ArrayList<BookEventListener> bookNotificationListeners = new ArrayList<>();
		bookNotificationListeners.add(new SimpleBookEventListener());
		bookNotificationListeners.add(new SimpleBookEventListener());
		
		
		// set Dependencies
		mapBooksService.setBooks(testData);
		mapBooksService.setIsbnGenerator(isbnGeneratorImpl);
		mapBooksService.setStoreService(storeService());

		simpleOrderService.setBooksService(mapBooksService);
		simpleOrderService.setIdGenerator(theIdGenerator);
		simpleOrderService.setStoreService(storeService());

		isbnGeneratorImpl.setPrefix("ISBN:");
		isbnGeneratorImpl.setCountryCode("-dk");

		serializingBooksService.setDelegate(validatingBooksService);
		validatingBooksService.setDelegate(mapBooksService);
		notifyingBooksService.setDelegate(serializingBooksService);
		notifyingBooksService.setBookNotificationSupport(bookNotificationSupport);
		bookNotificationSupport.setListeners(bookNotificationListeners);
		// Offer objects
		isbnGenerator = isbnGeneratorImpl;
		booksService = notifyingBooksService;
		orderService = simpleOrderService;
		idGenerator = theIdGenerator;

	}

	public static BooksService booksService() {
		return booksService;
	}

	public static IsbnGenerator isbnGenerator() {
		return isbnGenerator;
	}

	public static StoreService storeService() {
		// Method Scoped, just as an example...
		AuditingStoreServiceDecorator auditingStoreServiceDecorator = new AuditingStoreServiceDecorator();
		StoreService implemenentation = new AuditingStoreService();
		auditingStoreServiceDecorator.setStoreService(implemenentation);
		return auditingStoreServiceDecorator;
	}

	public static OrderService orderService() {
		return orderService;
	}

	public static IdGenerator idGenerator() {
		return idGenerator;
	}

}
