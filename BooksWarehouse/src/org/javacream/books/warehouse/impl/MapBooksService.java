package org.javacream.books.warehouse.impl;

import java.util.Collection;
import java.util.Map;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookBuilder;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;

/**
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto rainer.sawitzki@javacream.org
 * 
 */

public class MapBooksService implements BooksService {

	public MapBooksService() {

	}

	private Map<String, Book> books;
	private IsbnGenerator isbnGenerator;
	private StoreService storeService;

	private BookBuilder bookBuilder;

	{
		// books = new HashMap<String, Book>();
		// isbnGenerator = new RandomIsbnGenerator();
		// storeService = new DummyStoreService();
	}

	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}

	public void setBookBuilder(BookBuilder bookBuilder) {
		this.bookBuilder = bookBuilder;
	}

	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javacream.books.warehouse.impl.BooksService#newBook(java.lang.String,
	 * java.util.Map)
	 */
	@Override
	public String newBook(String title, Map<String, Object> options) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = bookBuilder.setIsbn(isbn).setTitle(title).setOptions(options).build();
		books.put(isbn, book);
		return isbn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javacream.books.warehouse.impl.BooksService#findBookByIsbn(java.lang.
	 * String)
	 */
	@Override
	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = (Book) books.get(isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
		int stock = storeService.getStock("books", isbn);
		result.setAvailable(stock > 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javacream.books.warehouse.impl.BooksService#updateBook(org.javacream.
	 * books.warehouse.api.Book)
	 */
	@Override
	public Book updateBook(Book bookDetailValue) throws BookException {
		Book value = books.get(bookDetailValue.getIsbn());
		value.setTitle(bookDetailValue.getTitle());
		value.setPrice(bookDetailValue.getPrice());
		value.setAvailable(bookDetailValue.isAvailable());
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javacream.books.warehouse.impl.BooksService#deleteBookByIsbn(java.
	 * lang.String)
	 */
	@Override
	public void deleteBookByIsbn(String isbn) throws BookException {
		Object result = books.remove(isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.javacream.books.warehouse.impl.BooksService#findAllBooks()
	 */
	@Override
	public Collection<Book> findAllBooks() {
		return books.values();
	}

}
