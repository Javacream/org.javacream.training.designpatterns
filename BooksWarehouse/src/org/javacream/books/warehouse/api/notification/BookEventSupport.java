package org.javacream.books.warehouse.api.notification;

import java.util.List;

public class BookEventSupport {

	private List<BookEventListener> listeners;
	
	public void setListeners(List<BookEventListener> listeners) {
		this.listeners = listeners;
	}

	public void fireBookCreatedNotification(String isbn){
		BookEvent bookNotification = new BookEvent(isbn, System.currentTimeMillis(), BookEventAction.CREATED);
		fireBookNotification(bookNotification);
	}
	public void fireBookUpdatedNotification(String isbn){
		BookEvent bookNotification = new BookEvent(isbn, System.currentTimeMillis(), BookEventAction.UPDATED);
		fireBookNotification(bookNotification);
		
	}
	public void fireBookDeletedNotification(String isbn){
		BookEvent bookNotification = new BookEvent(isbn, System.currentTimeMillis(), BookEventAction.DELETED);
		fireBookNotification(bookNotification);
		
	}
	
	private void fireBookNotification(BookEvent bookNotification){
		for (BookEventListener listener: listeners){
			listener.handle(bookNotification);
		}
	}
}
