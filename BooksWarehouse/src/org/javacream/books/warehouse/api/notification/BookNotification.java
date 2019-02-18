package org.javacream.books.warehouse.api.notification;

import java.io.Serializable;

public class BookNotification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String isbn;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookNotification other = (BookNotification) obj;
		if (action != other.action)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (timestamp != other.timestamp)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookNotification [isbn=" + isbn + ", timestamp=" + timestamp + ", action=" + action + "]";
	}
	public BookNotification(String isbn, long timestamp, BookNotificationAction action) {
		super();
		this.isbn = isbn;
		this.timestamp = timestamp;
		this.action = action;
	}
	public String getIsbn() {
		return isbn;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public BookNotificationAction getAction() {
		return action;
	}
	private long timestamp;
	private BookNotificationAction action;
}
