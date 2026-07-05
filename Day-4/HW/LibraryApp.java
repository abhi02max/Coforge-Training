package com.coforge.assignment;

public class LibraryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library library = new Library();

        library.addBook(new Book(1, "Java"));
        library.addBook(new Book(2, "Python"));
        library.addBook(new Book(3, "SQL"));

        library.issueBook(2);

        library.searchBook("Python");

        library.returnBook(2);

        library.searchBook("Python");
	}

}