package br.com.saitodisse.learning;

public class Book {
	private String name;
	private String author;
	private Person person;
	
	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(this.getName());
		sb.append("]");
		
		Person personBook = this.getPerson();
		if(personBook != null){ 
			sb.append(" is checked out to ");
			sb.append(personBook.getName());
		}
		else{
			sb.append(" is free");
		}
		
		return sb.toString();
	}

}
