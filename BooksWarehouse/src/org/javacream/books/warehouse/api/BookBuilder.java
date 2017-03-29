package org.javacream.books.warehouse.api;

import java.util.Map;
import java.util.Set;

public class BookBuilder {
	
	private String isbn;
	private String title;
	private double price;
	private Map<String, Object> options;
	
	private Map<Set<String>, BookCreator> creators;
	
	public void setCreators(Map<Set<String>, BookCreator> creators) {
		this.creators = creators;
	}


	public BookBuilder setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}


	public BookBuilder setTitle(String title) {
		this.title = title;
		return this;
	}


	public BookBuilder setPrice(double price) {
		this.price = price;
		return this;

	}


	public BookBuilder setOptions(Map<String, Object> options) {
		this.options = options;
		return this;

	}


	public Book build(){
		return creators.get(options.keySet()).create(isbn, title, price, options);
	}
}
