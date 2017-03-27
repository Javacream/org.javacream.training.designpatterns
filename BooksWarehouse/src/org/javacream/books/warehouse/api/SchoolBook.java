package org.javacream.books.warehouse.api;

public class SchoolBook extends Book{

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
