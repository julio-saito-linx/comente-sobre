package br.com.saitodisse.learning;

import java.text.MessageFormat;
import java.util.ArrayList;

public class MyLibrary {

	private String name;
	private ArrayList<Person> persons;

	public MyLibrary(String name){
		this.setName(name);
		this.books = new ArrayList<Book>();
		this.persons = new ArrayList<Person>();
	}

	private ArrayList<Book> books;

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void addPerson(Person person) {
		this.persons.add(person);
	}

	public boolean checkout(Book book, Person person) throws MaxBooksException {
		if(book.getPerson() == null){
			validatesMaximumBooks(person);
			book.setPerson(person);
			return true;
		}
		else{
			// the book is already checkout 
			return false;
		}
	}

	public boolean checkIn(Book book) {
		if(book.getPerson() != null){
			book.setPerson(null);
			return true;
		}
		else{
			// the book is already in the library 
			return false;
		}
	}

	public ArrayList<Book> getBooksFromPerson(Person person) {
		ArrayList<Book> booksFromPerson = new ArrayList<Book>();
		for(Book b : getBooks()){
			if(b.getPerson() != null &&
			   b.getPerson().getName().equals(person.getName())){
				booksFromPerson.add(b);
			}
		}
		return booksFromPerson;
	}
	
	public void validatesMaximumBooks(Person person) throws MaxBooksException {
		ArrayList<Book> booksPerson = getBooksFromPerson(person);
		if(booksPerson.size() >= person.getMaximumBooks()){
			throw new MaxBooksException();
		}
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("{0} books and {1} persons", 
				this.getBooks().size(), 
				this.getPersons().size());
	}
}
