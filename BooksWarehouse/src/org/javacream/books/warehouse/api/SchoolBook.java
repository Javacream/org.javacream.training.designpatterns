package org.javacream.books.warehouse.api;

public class SchoolBook extends Book{

	public SchoolBook() {
		super();
	}
	public SchoolBook(String isbn, String title, double price, boolean available, int year, String subject) {
		super(isbn, title, price, available);
		this.year = year;
		this.subject = subject;
	}
	private static final long serialVersionUID = 1L;

	private int year;
	private String subject;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
