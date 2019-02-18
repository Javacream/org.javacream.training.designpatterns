package org.javacream.books.warehouse.api.notification;

public interface BookEventListener {

	public void handle(BookEvent bookNotification);
}
