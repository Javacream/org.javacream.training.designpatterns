package org.javacream.books.warehouse.impl.notification;

import org.javacream.books.warehouse.api.notification.BookNotification;
import org.javacream.books.warehouse.api.notification.BookNotificationListener;

public class SimpleBookNotificationListener implements BookNotificationListener {

	@Override
	public void handle(BookNotification bookNotification) {
		System.out.println("Notification: " + bookNotification + " registered by " + this );
	}

}
