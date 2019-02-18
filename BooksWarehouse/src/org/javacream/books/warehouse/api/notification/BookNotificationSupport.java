package org.javacream.books.warehouse.api.notification;

import java.util.List;

public class BookNotificationSupport {

	private List<BookNotificationListener> listeners;
	
	public void setListeners(List<BookNotificationListener> listeners) {
		this.listeners = listeners;
	}

	public void fireBookCreatedNotification(String isbn){
		BookNotification bookNotification = new BookNotification(isbn, System.currentTimeMillis(), BookNotificationAction.CREATED);
		fireBookNotification(bookNotification);
	}
	public void fireBookUpdatedNotification(String isbn){
		BookNotification bookNotification = new BookNotification(isbn, System.currentTimeMillis(), BookNotificationAction.UPDATED);
		fireBookNotification(bookNotification);
		
	}
	public void fireBookDeletedNotification(String isbn){
		BookNotification bookNotification = new BookNotification(isbn, System.currentTimeMillis(), BookNotificationAction.DELETED);
		fireBookNotification(bookNotification);
		
	}
	
	private void fireBookNotification(BookNotification bookNotification){
		for (BookNotificationListener listener: listeners){
			listener.handle(bookNotification);
		}
	}
}
