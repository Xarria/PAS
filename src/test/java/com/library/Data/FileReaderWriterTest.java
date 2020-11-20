package com.library.Data;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class FileReaderWriterTest {

    @Test
    void readFromFile() {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<Book> arrBook = fileReaderWriter.readFromFile("book");
        ArrayList<Newspaper> arrNewspaper = fileReaderWriter.readFromFile("newspaper");
        ArrayList<Renter> arrRenter = fileReaderWriter.readFromFile("renter");

        Assert.assertEquals("BookTitle", arrBook.get(0).getName());
        Assert.assertEquals("BookAuthor", arrBook.get(0).getAuthor());
        Assert.assertEquals("BookGenre", arrBook.get(0).getGenre());
        Assert.assertEquals(2115, arrBook.get(0).getPages());

        Assert.assertEquals("NewspaperTitle", arrNewspaper.get(0).getName());
        Assert.assertEquals("NewspaperGenre", arrNewspaper.get(0).getGenre());

        Assert.assertEquals("RenterName", arrRenter.get(0).getName());
        Assert.assertEquals("RenterSurname", arrRenter.get(0).getSurname());
        Assert.assertEquals("RenterLogin", arrRenter.get(0).getLogin());
    }

    @Test
    void writeToFile() {
        // store old data
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<Book> arrBook = fileReaderWriter.readFromFile("book");
        ArrayList<Newspaper> arrNewspaper = fileReaderWriter.readFromFile("newspaper");
        ArrayList<Renter> arrRenter = fileReaderWriter.readFromFile("renter");

        // create sample data
        Book book = new Book("Name", "Genre", "Author", 2115);
        Newspaper newspaper = new Newspaper("Name", "Genre");
        Renter renter = new Renter("Name", "Surname", "Login");
        ArrayList<Book> expectedBooks = new ArrayList<>(Collections.singletonList(book));
        ArrayList<Newspaper> expectedNewspapers = new ArrayList<>(Collections.singletonList(newspaper));
        ArrayList<Renter> expectedRenters = new ArrayList<>(Collections.singletonList(renter));

        // writing sample data to file
        fileReaderWriter.writeToFile(expectedBooks, "book");
        fileReaderWriter.writeToFile(expectedNewspapers, "newspaper");
        fileReaderWriter.writeToFile(expectedRenters, "renter");

        // actual tests
        Assert.assertEquals("Name", expectedBooks.get(0).getName());
        Assert.assertEquals("Author", expectedBooks.get(0).getAuthor());
        Assert.assertEquals("Genre", expectedBooks.get(0).getGenre());
        Assert.assertEquals(2115, expectedBooks.get(0).getPages());

        Assert.assertEquals("Name", expectedNewspapers.get(0).getName());
        Assert.assertEquals("Genre", expectedNewspapers.get(0).getGenre());

        Assert.assertEquals("Name", expectedRenters.get(0).getName());
        Assert.assertEquals("Surname", expectedRenters.get(0).getSurname());
        Assert.assertEquals("Login", expectedRenters.get(0).getLogin());

        // resting old data
        fileReaderWriter.writeToFile(arrBook, "book");
        fileReaderWriter.writeToFile(arrNewspaper, "newspaper");
        fileReaderWriter.writeToFile(arrRenter, "renter");
    }
}