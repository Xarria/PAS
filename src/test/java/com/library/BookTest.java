package com.library;


import com.library.Data.Book;
import com.library.Data.Place;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    public void testToString() {
        Book book = new Book("Godfather", "thriller", "Mario Puzo", 480);
        Place place = new Place("A", 1);
        book.setPlace(place);
        Assert.assertEquals("Godfather", book.getName());
        Assert.assertEquals("thriller", book.getGenre());
        Assert.assertEquals("Mario Puzo", book.getAuthor());
        Assert.assertEquals(480, book.getPages());
        Assert.assertEquals("\nKsiążka, tytuł: Godfather\ngatunek: thriller\nRegał: A, pozycja: 1\nautor: Mario Puzo" +
                "\nliczba stron: 480", book.toString());
    }
}