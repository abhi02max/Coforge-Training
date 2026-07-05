package com.coforge.assignment;

import java.util.ArrayList;

public class Library {
	ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println(b.title + " Added.");
    }

    public void issueBook(int id) {

        for (Book b : books) {

            if (b.id == id && !b.issued) {
                b.issued = true;
                System.out.println("Book Issued.");
                return;
            }
        }

        System.out.println("Book Not Available.");
    }

    public void returnBook(int id) {

        for (Book b : books) {

            if (b.id == id && b.issued) {
                b.issued = false;
                System.out.println("Book Returned.");
                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    public void searchBook(String title) {

        for (Book b : books) {

            if (b.title.equalsIgnoreCase(title)) {

                System.out.println("Book Found");
                System.out.println("ID : " + b.id);
                System.out.println("Title : " + b.title);

                if (b.issued)
                    System.out.println("Status : Issued");
                else
                    System.out.println("Status : Available");

                return;
            }
        }

        System.out.println("Book Not Found");
    }
}