package org.javacream.books.warehouse;

public class SpecialistBook extends Book{

	private static final long serialVersionUID = 1L;

	private String topic;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
}
