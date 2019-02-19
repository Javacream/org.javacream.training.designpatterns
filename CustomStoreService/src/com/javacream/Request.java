package com.javacream;

import java.io.Serializable;

public class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String catalog;
	private Object itemId;
	@Override
	public String toString() {
		return "Request [catalog=" + catalog + ", itemId=" + itemId + "]";
	}
	public Request(String catalog, Object itemId) {
		super();
		this.catalog = catalog;
		this.itemId = itemId;
	}
	public String getCatalog() {
		return catalog;
	}
	public Object getItemId() {
		return itemId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
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
		Request other = (Request) obj;
		if (catalog == null) {
			if (other.catalog != null)
				return false;
		} else if (!catalog.equals(other.catalog))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}
}
