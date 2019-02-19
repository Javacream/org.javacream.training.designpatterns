package org.javacream.books.warehouse.api.event;

import java.io.Serializable;

public class BookEvent implements Serializable{

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
	    BookEvent other = (BookEvent) obj;
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
	    return "BookEvent [isbn=" + isbn + ", timestamp=" + timestamp + ", action=" + action + "]";
	}
	public BookEvent(String isbn, long timestamp, BookEventAction action) {
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
	public BookEventAction getAction() {
		return action;
	}
	private long timestamp;
	private BookEventAction action;
}
