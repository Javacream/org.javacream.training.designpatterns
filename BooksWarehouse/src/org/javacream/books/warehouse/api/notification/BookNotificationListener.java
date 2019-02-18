package org.javacream.books.warehouse.api.notification;

public interface BookNotificationListener {

	public void handle(BookNotification bookNotification);
}
