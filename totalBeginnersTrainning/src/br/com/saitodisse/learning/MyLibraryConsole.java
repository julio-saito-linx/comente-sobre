package br.com.saitodisse.learning;

import java.text.MessageFormat;

public class MyLibraryConsole {
	private static Book book1;
	private static Book book2;
	private static Book book3;
	private static Book book4;
	private static Person person1;
	private static Person person2;
	private static MyLibrary myLib;

	public static void main(String[] args) {
		getIntialState();

		System.out.println(MessageFormat.format("Welcome! to {0}\n", myLib.getName()));
		System.out.println(myLib);
		System.out.println("\npersons:");
		for (Person person : myLib.getPersons()) {
			System.out.println(MessageFormat.format("  {0}", person));
		}

		printStatus(myLib);

		System.out.println("\nJoao checkout 2 books:");
		try {
			myLib.checkout(book1, person1);
			myLib.checkout(book2, person1);
		} catch (MaxBooksException e) {
			e.printStackTrace();
		}
		printStatus(myLib);


		System.out.println("\nJoao tries to checkout 1 more");
		try {
			myLib.checkout(book3, person1);
		} catch (MaxBooksException e) {
			System.out.println(MessageFormat.format("\n!!sorry, {0}. You reach your maximum ammount of books to checkout!!",
					person1.getName()));
		}
		printStatus(myLib);

		System.out.println("\nJoao checkin book1");
		myLib.checkIn(book1);
		printStatus(myLib);


	}

	private static void getIntialState() {
		myLib = new MyLibrary("Livraria virtual");
		book1 = new Book("Livro 1");
		book2 = new Book("Livro 2");
		book3 = new Book("Livro 3");
		book4 = new Book("Livro 4");

		myLib.addBook(book1);
		myLib.addBook(book2);
		myLib.addBook(book3);
		myLib.addBook(book4);

		person1 = new Person("Joao", 2);
		person2 = new Person("Maria", 2);

		myLib.addPerson(person1);
		myLib.addPerson(person2);
	}

	private static void printStatus(MyLibrary myLib) {
		System.out.println("------------------");
		for (Book book : myLib.getBooks()) {
			System.out.println(MessageFormat.format("  {0}", book));
		}
		System.out.println("------------------");
	}
}
