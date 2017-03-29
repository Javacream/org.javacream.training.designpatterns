package org.javacream.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.impl.SimpleOrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookBuilder;
import org.javacream.books.warehouse.api.BookCreator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.SchoolBook;
import org.javacream.books.warehouse.api.SpecialistBook;
import org.javacream.books.warehouse.api.notification.BookNotificationListener;
import org.javacream.books.warehouse.api.notification.BookNotificationSupport;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.books.warehouse.impl.decorators.NotifyingBooksService;
import org.javacream.books.warehouse.impl.decorators.SerializingBooksService;
import org.javacream.books.warehouse.impl.decorators.ValidatingBooksService;
import org.javacream.books.warehouse.impl.notification.SimpleBookNotificationListener;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.adapter.CustomStoreServiceAdapter;
import org.javacream.store.impl.decorators.AuditingStoreServiceDecorator;
import org.javacream.util.IdGenerator;
import org.javacream.util.aspects.Aspect;
import org.javacream.util.aspects.TracingAspect;
import org.javacream.util.aspects.impl.NetworkSimulatorAspectListener;
import org.javacream.util.aspects.impl.ProfilingAspectListener;
import org.javacream.util.aspects.impl.TracingAspectListener;

public abstract class ApplicationContext {

	private static IsbnGenerator isbnGenerator;
	private static BooksService booksService;
	private static OrderService orderService;
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
		NotifyingBooksService notifyingBooksService = new NotifyingBooksService();
		
		BookNotificationSupport bookNotificationSupport = new BookNotificationSupport();
		ArrayList<BookNotificationListener> bookNotificationListeners = new ArrayList<>();
		
		BookBuilder bookBuilder = new BookBuilder();
		HashMap<Set<String>, BookCreator> creators = new HashMap<>();
		bookBuilder.setCreators(creators);
		HashSet<String> bookCreatorKey = new HashSet<>();
		creators.put(bookCreatorKey, (isbn, title, price, options) -> new Book(isbn, title, price, false));
		bookCreatorKey = new HashSet<>();
		bookCreatorKey.add("topic");
		creators.put(bookCreatorKey, (isbn, title, price, options) -> new SpecialistBook(isbn, title, price, false, (String)options.get("topic")));
		bookCreatorKey = new HashSet<>();
		bookCreatorKey.add("subject");
		bookCreatorKey.add("year");
		creators.put(bookCreatorKey, (isbn, title, price, options) -> new SchoolBook(isbn, title, price, false, (int)options.get("year"), (String)options.get("subject")));

		// set Dependencies
		mapBooksService.setBooks(testData);
		mapBooksService.setIsbnGenerator(isbnGeneratorImpl);
		mapBooksService.setStoreService(storeService());
		mapBooksService.setBookBuilder(bookBuilder);
		
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
		bookNotificationListeners.add(new SimpleBookNotificationListener());
		bookNotificationListeners.add(new SimpleBookNotificationListener());

		
		
		// Offer objects
		isbnGenerator = isbnGeneratorImpl;
		booksService = TracingAspect.addAspect(notifyingBooksService);
		orderService = Aspect.addAspect(simpleOrderService, new TracingAspectListener(), new ProfilingAspectListener(), new NetworkSimulatorAspectListener(200));
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
		//StoreService implemenentation = new AuditingStoreService();
		CustomStoreServiceAdapter customStoreServiceAdapter = new CustomStoreServiceAdapter();
		auditingStoreServiceDecorator.setStoreService(customStoreServiceAdapter);
		return auditingStoreServiceDecorator;
	}

	public static OrderService orderService() {
		return orderService;
	}

	public static IdGenerator idGenerator() {
		return idGenerator;
	}

}
