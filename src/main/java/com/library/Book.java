package com.library;

public class Book extends Elem{
    private String author;
    private int pages;

    public Book(String name, String genre, String author, int pages) {
        super(name, genre);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String toString(){
        return "\nKsiążka" + super.toString() + "\nautor: " + author + "\nliczba stron: " + pages;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }
}
