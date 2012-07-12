package br.com.saitodisse.learning;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest  {
	
	@Test
	public void constructor(){
		Book book = new Book("Meu livro");
		assertEquals("Meu livro", book.getName());
		assertEquals(null, book.getAuthor());
	}
	
	@Test
	public void getPerson(){
		Book book = new Book("Meu livro");
		Person person = new Person("Mario", 1);
		book.setPerson(person);
		
		assertEquals(book.getPerson().getName(), person.getName());
	}

	@Test
	public void book_toString(){
		Book book = new Book("Meu livro");
		Person person = new Person("Mario", 1);

		assertEquals("[Meu livro] is free", book.toString());
		book.setPerson(person);
		assertEquals("[Meu livro] is checked out to Mario", book.toString());
	}

}
