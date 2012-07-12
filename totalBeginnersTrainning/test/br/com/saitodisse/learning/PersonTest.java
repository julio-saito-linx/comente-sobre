package br.com.saitodisse.learning;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest  {

	@Test
	public void contructor_empty() {
		Person person = new Person();
		assertEquals(null, person.getName());
		assertEquals(0, person.getMaximumBooks());
		
		Date date = new Date();
		assertEquals(date, person.getCreationDate());
	}

	@Test
	public void construtor_filled() {
		Person person = new Person("nome", 10);
		assertEquals("nome", person.getName());
		assertEquals(10, person.getMaximumBooks());
		
		Date date = new Date();
		assertEquals(date, person.getCreationDate());
	}

	@Test
	public void setGetName() {
		Person person = new Person();
		assertEquals(null, person.getName());
		
		person.setName("Mauro");
		assertEquals("Mauro", person.getName());
	}

	@Test
	public void setGetMaximumBooks() {
		Person person = new Person();
		assertEquals(0, person.getMaximumBooks());
		
		person.setMaximumBooks(10);	
		assertEquals(10, person.getMaximumBooks());
	}
	
	@Test
	public void person_toString(){
		Person person = new Person("nome", 10);
		assertEquals("nome", person.toString());
	}


}
