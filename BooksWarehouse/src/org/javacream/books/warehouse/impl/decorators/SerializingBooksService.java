package org.javacream.books.warehouse.impl.decorators;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;

public class SerializingBooksService extends BaseBooksServiceDecorator{
	

	public Book findBookByIsbn(String isbn) throws BookException {
		return (Book)SerializationUtils.clone(delegate.findBookByIsbn(isbn));
	}

	public Book updateBook(Book bookDetailValue) throws BookException {
		return (Book)SerializationUtils.clone(delegate.updateBook((Book)SerializationUtils.clone(bookDetailValue)));
	}

	public Collection<Book> findAllBooks() {
		return (Collection<Book>) SerializationUtils.clone(new ArrayList<Book>(delegate.findAllBooks()));
	}

}
