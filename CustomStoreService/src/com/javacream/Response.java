package com.javacream;

import java.io.Serializable;

public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int availableItems;
	private long timestamp;
	private String catalog;
	private Object item;
	@Override
	public String toString() {
		return "Response [availableItems=" + availableItems + ", timestamp=" + timestamp + ", catalog=" + catalog
				+ ", item=" + item + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availableItems;
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		Response other = (Response) obj;
		if (availableItems != other.availableItems)
			return false;
		if (catalog == null) {
			if (other.catalog != null)
				return false;
		} else if (!catalog.equals(other.catalog))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (timestamp != other.timestamp)
			return false;
		return true;
	}
	public Response(int availableItems, long timestamp, String catalog, Object item) {
		super();
		this.availableItems = availableItems;
		this.timestamp = timestamp;
		this.catalog = catalog;
		this.item = item;
	}
	public int getAvailableItems() {
		return availableItems;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public String getCatalog() {
		return catalog;
	}
	public Object getItem() {
		return item;
	}
}
