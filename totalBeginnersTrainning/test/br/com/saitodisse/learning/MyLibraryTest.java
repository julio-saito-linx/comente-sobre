package br.com.saitodisse.learning;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyLibraryTest {

	private MyLibrary myLib;
	private Book book1;
	private Book book2;
	private Person person2;
	private Person person1;

	@Before
	public void SetUp() {
		person1 = new Person("João", 5);
		person2 = new Person("Maria", 2);

		book1 = new Book("Primeiro livro");
		book2 = new Book("Segundo livro");

		myLib = new MyLibrary("Biblioteca com nome");
		myLib.addPerson(person1);
		myLib.addPerson(person2);
		myLib.addBook(book1);
		myLib.addBook(book2);
	}

	@Test
	public void must_have_a_name() {
		assertTrue("biblioteca não tem nome", myLib.getName().length() > 0);
	}

	@Test
	public void can_add_books() {
		assertEquals(0, myLib.getBooks().indexOf(book1));
		assertEquals(2, myLib.getBooks().size());
	}

	@Test
	public void can_add_persons() {
		assertEquals(0, myLib.getPersons().indexOf(person1));
		assertEquals(2, myLib.getPersons().size());
	}

	@Test
	public void checkout_receives_a_person_in_a_book() {
		boolean checkoutResult = false;
		try {
			checkoutResult = myLib.checkout(book1, person1);
		} catch (MaxBooksException e) {
			new AssertionError();
		}
		assertEquals(person1.getName(), book1.getPerson().getName());
		assertEquals(true, checkoutResult);
	}

	@Test
	public void checkout_cannot_take_an_checkouted_book() throws Throwable {
		boolean checkoutResult = myLib.checkout(book1, person1);
		assertEquals(true, checkoutResult);

		checkoutResult = myLib.checkout(book1, person2);
		assertEquals(false, checkoutResult);
	}

	@Test
	public void checkin_sets_bookPerson_to_null() throws Throwable {
		myLib.checkout(book1, person1);
		boolean checkInResult = myLib.checkIn(book1);
		assertTrue("The cannot be checked in", checkInResult);
		assertNull("The must not have a person anymore", book1.getPerson());
	}

	@Test
	public void getBooksFromPerson() throws Throwable{
		person1.setMaximumBooks(10);
		
		assertEquals(0, myLib.getBooksFromPerson(person1).size());
		assertEquals(true, myLib.checkout(book1, person1));
		assertEquals(1, myLib.getBooksFromPerson(person1).size());
		assertEquals(true, myLib.checkout(book2, person1));
		assertEquals(2, myLib.getBooksFromPerson(person1).size());
	}

	@Test(expected=MaxBooksException.class)
	public void a_person_must_not_have_more_books_then_the_maximun() throws Throwable {
		
		myLib.getBooksFromPerson(person1);
		// can only have 1
		person1.setMaximumBooks(1);

		assertEquals(true, myLib.checkout(book1, person1));

		//maximum book reached, throws MaxBooksException
		myLib.checkout(book2, person1);
	}

	@Test
	public void myLib_toString(){
		assertEquals("2 books and 2 persons", myLib.toString());
	}
}
