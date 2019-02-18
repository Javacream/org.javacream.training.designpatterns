package org.javacream.books.warehouse.api.event;

public interface BookEventListener {

	public void handle(BookEvent bookNotification);
}
