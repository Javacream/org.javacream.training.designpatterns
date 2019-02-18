package org.javacream.books.warehouse.impl.event;

import org.javacream.books.warehouse.api.notification.BookEvent;
import org.javacream.books.warehouse.api.notification.BookEventListener;

public class SimpleBookEventListener implements BookEventListener {

	@Override
	public void handle(BookEvent bookNotification) {
		System.out.println("Notification: " + bookNotification + " registered by " + this );
	}

}
