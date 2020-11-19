package com.library.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ElemRepoInterface {

    void add(Object element);
    void remove(Elem elem);
    Elem findElement(UUID id);
    void modifyElement(UUID id, Elem elem);
    boolean isElementInRepository(Elem elem);
    boolean isPlaceFree(Place place);
    ArrayList<Elem> getAllElementsFromGenre(String g);
    ArrayList<Book> findBooksByAuthor(String a);
    ArrayList<Elem> findByTitle(String title);
    Place findElementPlace(Elem element);
    String toString(Elem elem, RentRepoInterface rentRepo);
    String getRentForElement(Elem elem, RentRepoInterface rentRepo);
    List<Elem> getElements();
}
