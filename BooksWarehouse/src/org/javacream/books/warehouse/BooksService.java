package org.javacream.books.warehouse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;

/**
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto rainer.sawitzki@javacream.org
 * 
 */

public class BooksService{

	public BooksService(){
		
	}
	private Map<String, Book> books;
	
	{
		books = new HashMap<String, Book>();
	}

	

	public String newBook(String title, Map<String, Object> options) throws BookException {
		String isbn = "Isbn" + Math.random(); 
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
		books.put(isbn, book);
		return isbn;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = (Book) books.get(isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND,
					isbn);
		}
		int stock = 0;
		//retrieve stock from external service, e.g. web service call...

		result.setAvailable(stock > 0);
		//Don't return internal Book if you don't use a database! 
		result = (Book) SerializationUtils.clone(result);
		return result;
	}

	public Book updateBook(Book bookDetailValue) throws BookException {
		//Take a copy to prevent external manipulation!
		bookDetailValue = (Book) SerializationUtils.clone(bookDetailValue);

		if (bookDetailValue.getPrice() <= 0) {
			throw new BookException(BookException.BookExceptionType.CONSTRAINT,
					"price <= 0");
		}

		Book value = books.get(bookDetailValue.getIsbn());
		value.setTitle(bookDetailValue.getTitle());
		value.setPrice(bookDetailValue.getPrice());
		value.setAvailable(bookDetailValue.isAvailable());
		return value;
	}

	public void deleteBookByIsbn(String isbn) throws BookException {
		Object result = books.remove(isbn);
		if (result == null) {
			throw new BookException(
					BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}


	public Collection<Book> findAllBooks() {
		return (Collection<Book>) SerializationUtils.clone(new ArrayList<Book>(books.values()));
	}
	
}
