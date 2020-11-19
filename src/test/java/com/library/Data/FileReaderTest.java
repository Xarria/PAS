package com.library.Data;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class FileReaderTest {

    @Test
    void readFromFile() {
        FileReader fileReader = new FileReader();
        ArrayList<Book> arrBook = fileReader.readFromFile("book");
        ArrayList<Newspaper> arrNewspaper = fileReader.readFromFile("newspaper");
        ArrayList<Renter> arrRenter = fileReader.readFromFile("renter");

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
}