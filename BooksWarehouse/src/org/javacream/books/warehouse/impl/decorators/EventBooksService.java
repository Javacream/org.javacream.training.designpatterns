package org.javacream.books.warehouse.impl.decorators;

import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.event.BookEventSupport;

public class EventBooksService extends BaseBooksServiceDecorator{
	

	private BookEventSupport bookNotificationSupport;
	
	
	public void setBookNotificationSupport(BookEventSupport bookNotificationSupport) {
		this.bookNotificationSupport = bookNotificationSupport;
	}

	@Override
	public String newBook(String title, Map<String, Object> options) throws BookException {
		String isbn = super.newBook(title, options);
		bookNotificationSupport.fireBookCreatedNotification(isbn);
		return isbn;
	}

	@Override
	public void deleteBookByIsbn(String isbn) throws BookException {
		super.deleteBookByIsbn(isbn);
		bookNotificationSupport.fireBookDeletedNotification(isbn);
	}

	public Book updateBook(Book bookDetailValue) throws BookException {
		Book updated = delegate.updateBook(bookDetailValue);
		bookNotificationSupport.fireBookUpdatedNotification(bookDetailValue.getIsbn());
		return updated;
	}


}
