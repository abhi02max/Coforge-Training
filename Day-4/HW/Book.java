package com.coforge.assignment;

public class Book {
	int id;
    String title;
    boolean issued;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
    }
}