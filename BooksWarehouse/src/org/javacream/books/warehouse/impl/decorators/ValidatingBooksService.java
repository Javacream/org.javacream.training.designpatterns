package org.javacream.books.warehouse.impl.decorators;

import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BookException.BookExceptionType;

public class ValidatingBooksService extends BaseBooksServiceDecorator{


	public Book updateBook(Book bookDetailValue) throws BookException {
		if (bookDetailValue.getPrice() <= 0) {
			throw new BookException(BookException.BookExceptionType.CONSTRAINT,
					"price <= 0");
		}
		return delegate.updateBook(bookDetailValue);
	}

	@Override
	public String newBook(String title, Map<String, Object> options) throws BookException {
		if (title == null || title.trim().length() == 0){
			throw new BookException(BookExceptionType.NOT_CREATED, "invalid title");
		}
		return super.newBook(title, options);
	}


}
