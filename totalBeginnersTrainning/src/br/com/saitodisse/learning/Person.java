package br.com.saitodisse.learning;

import java.util.Date;

public class Person {
	private String name;
	private int maximumBooks;
	private Date creationDate;

	public Person() {
		this.creationDate = new Date();
	}

	/**
	 * @param name
	 * @param maximumBooks
	 */
	public Person(String name, int maximumBooks) {
		this.creationDate = new Date();
		this.name = name;
		this.maximumBooks = maximumBooks;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getMaximumBooks() {
		return maximumBooks;
	}
	public void setMaximumBooks(int maximumBooks) {
		this.maximumBooks = maximumBooks;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return name;
	}
}
