package org.javacream.books.warehouse.impl.event;

import org.javacream.books.warehouse.api.event.BookEvent;
import org.javacream.books.warehouse.api.event.BookEventListener;

public class SimpleBookEventListener implements BookEventListener {

	@Override
	public void handle(BookEvent bookNotification) {
		System.out.println("Notification: " + bookNotification + " registered by " + this );
	}

}
