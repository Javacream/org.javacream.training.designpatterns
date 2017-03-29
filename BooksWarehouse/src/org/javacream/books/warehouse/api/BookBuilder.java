package org.javacream.books.warehouse.api;

import java.util.Map;

public class BookBuilder {

	public Book create(String isbn, String title, Map<String, Object> options){
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
		return book;
	}
}
