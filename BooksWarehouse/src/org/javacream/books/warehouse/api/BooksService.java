package org.javacream.books.warehouse.api;

import java.util.Collection;
import java.util.Map;

public interface BooksService {

	String newBook(String title, Map<String, Object> options) throws BookException;

	Book findBookByIsbn(String isbn) throws BookException;

	Book updateBook(Book bookDetailValue) throws BookException;

	void deleteBookByIsbn(String isbn) throws BookException;

	Collection<Book> findAllBooks();

}