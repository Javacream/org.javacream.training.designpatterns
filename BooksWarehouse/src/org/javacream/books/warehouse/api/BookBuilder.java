package org.javacream.books.warehouse.api;

import java.util.Map;

public class BookBuilder {
	
	private String isbn;
	private String title;
	private double price;
	private Map<String, Object> options;
	
	
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
		Book book = new Book();
		String topic =(String) options.get("topic"); 
		if(topic != null){
			SpecialistBook specialistBook = new SpecialistBook();
			specialistBook.setTopic(topic);
			book = specialistBook;
		}
		String subject =(String) options.get("subject"); 
		Integer year =(Integer) options.get("year"); 
		if(subject != null && year != null){
			SchoolBook schoolBook = new SchoolBook();
			schoolBook.setYear(year);
			schoolBook.setSubject(subject);
			book = schoolBook;
		}
		
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setPrice(price);
		return book;
	}
}
